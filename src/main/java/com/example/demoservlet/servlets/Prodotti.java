package com.example.demoservlet.servlets;

import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Prodotti", value = "/Prodotti")
public class Prodotti extends HttpServlet {


    @Resource(name="jdbc/postgres")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        try {
            Connection con = ds.getConnection();
            Statement st = con.createStatement();
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Ciao" + "</h1>");
            ResultSet rs = st.executeQuery("select nome from prodotti");
            while (rs.next()){
                out.println("<p>"+ rs.getString(1)+ "</p>");
            }

            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
