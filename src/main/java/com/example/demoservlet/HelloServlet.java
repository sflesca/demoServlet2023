package com.example.demoservlet;

import java.io.*;
import java.util.List;

import com.example.demoservlet.model.ProvaEntity;
import jakarta.persistence.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query q  = em.createNamedQuery("getProva");
        List<ProvaEntity> lc = q.getResultList();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        if(!lc.isEmpty())
            out.println(lc.get(0).getId());
        em.getTransaction().begin();
        ProvaEntity pe = new ProvaEntity();
        pe.setNome("ciao");
        em.persist(pe);
        pe.setNome("pippo");
        em.getTransaction().commit();
        out.println("</body></html>");
    }

    public void destroy() {
    }
}