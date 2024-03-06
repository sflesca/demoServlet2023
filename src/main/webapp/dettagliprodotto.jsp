<%--
  Created by IntelliJ IDEA.
  User: sfles
  Date: 05/03/2023
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@page import="com.example.demoservlet.model.ProdottoOld"%>
    <jsp:useBean id="prodotto" scope="request" class="com.example.demoservlet.model.ProdottoOld" />
</head>
<body>
<jsp:getProperty name="prodotto" property="id"/>,
<jsp:getProperty name="prodotto" property="nome"/>,
<jsp:getProperty name="prodotto" property="prezzo"/>
</body>
</html>
