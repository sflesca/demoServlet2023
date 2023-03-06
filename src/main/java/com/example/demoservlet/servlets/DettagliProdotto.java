package com.example.demoservlet.servlets;

import com.example.demoservlet.model.Prodotto;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DettagliProdotto", value = "/DettagliProdotto")
public class DettagliProdotto extends HttpServlet {

    @Resource(name = "jdbc/postgres")
    private DataSource ds;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idstr = request.getParameter("idp");
        int pid  = Integer.parseInt(idstr);
        Prodotto prodotto = getProdotto(pid);
        request.setAttribute("prodotto", prodotto);
        gotoPage("/dettagliprodotto.jsp",request,response);
    }

    private Prodotto getProdotto(int pid) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Prodotto p = null;
        try {
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select id, nome, prezzo from prodotti where id ="+pid);

            if (rs.next()) {
                p = new Prodotto(rs.getInt(1),rs.getString(2),rs.getDouble(3));
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
                return p;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp =request.getRequestDispatcher(url);
        disp.forward(request,response);
    }
}
