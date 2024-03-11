package com.example.demoservlet.servlets;

import com.example.demoservlet.model.ProvaEntity;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "jpaServlet", value = "/jpa-servlet")
public class JPAServlet extends HttpServlet {

    private String message;
    @Override
    public void init() throws ServletException {
        message = "Hello JPA!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query q  = em.createNamedQuery("getProva");
        List<ProvaEntity> lc = q.getResultList();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        if(!lc.isEmpty()) {
            out.println("<ul>");
            for (ProvaEntity p:lc) {
                out.println("<li>");
                out.println(p.getId());
                out.println(p.getNome());
                out.println("</li>");
            }
            out.println("</ul>");
        }else{
            out.println("Nessun risultato");
        }
/*
        em.getTransaction().begin();
        ProvaEntity pe = new ProvaEntity();
        pe.setNome("ciao");
        em.persist(pe);
        em.getTransaction().commit();
*/
        out.println("</body></html>");
    }
}
