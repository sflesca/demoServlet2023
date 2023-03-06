<%--
  Created by IntelliJ IDEA.
  User: sfles
  Date: 05/03/2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@page import="com.example.demoservlet.model.Prodotto"%>
    <jsp:useBean id="prodotti" scope="request" class="java.util.LinkedList" type="java.util.LinkedList<com.example.demoservlet.model.Prodotto>"/>
</head>
<body>
<h1>Lista Prodotti</h1>
<ul>
    <% for (Prodotto p:prodotti){ %>
    <li><a href="DettagliProdotto?idp=<%=p.getId()%>"> <%=p.getId()%></a>, <%=p.getNome()%>, <%=p.getPrezzo()%></li>
    <%}%>
</ul>
</body>
</html>
