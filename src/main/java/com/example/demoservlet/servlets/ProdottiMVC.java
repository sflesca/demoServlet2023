package com.example.demoservlet.servlets;

import com.example.demoservlet.model.ProdottoOld;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ProdottiMVC", value = "/ProdottiMVC")
public class ProdottiMVC extends HttpServlet {


    @Resource(name = "jdbc/postgres")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProdottoOld> prodotti = getProdotti();
        request.setAttribute("prodotti", prodotti);
        gotoPage("/prodotti.jsp",request,response);
    }

    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp =request.getRequestDispatcher(url);
        disp.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private List<ProdottoOld> getProdotti() {
        List<ProdottoOld> prodotti = new LinkedList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select id, nome, prezzo from prodotti");

            while (rs.next()) {
                prodotti.add(new ProdottoOld(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con!=null) con.close();
            }catch(SQLException e){
                    throw new RuntimeException(e);
            } finally {
                return prodotti;
            }
        }


    }
}
