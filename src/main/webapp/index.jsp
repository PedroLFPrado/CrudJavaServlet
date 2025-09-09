<%-- 
    Document   : index
    Created on : 8 de set. de 2025, 15:12:07
    Author     : Pedro Lemos / Gustavo Henrique
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    response.sendRedirect(ctx + "/produtos");
%>
