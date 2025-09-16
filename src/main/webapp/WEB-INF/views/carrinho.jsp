<%-- 
    Document   : carrinho
    Created on : 8 de set. de 2025, 14:05:43
    Author     : Pedro Lemos / Gustavo Henrique
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.crudproduto.model.Produto" %>
<%
    List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
    Double total = (Double) request.getAttribute("total");
    if (carrinho == null) carrinho = new java.util.ArrayList<>();
    if (total == null) total = 0.0;
    String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carrinho</title>
    <link rel="stylesheet" href="<%= ctx %>/css/style.css">
</head>
<body>
<div class="container">
    <h1>Carrinho de Compras</h1>
    <a href="<%= ctx %>/produtos">Voltar para Produtos</a>
    <table>
        <tr><th>Código</th><th>Descrição</th><th>Preço</th><th>Ação</th></tr>
        <% for (Produto p : carrinho) { %>
        <tr>
            <td><%= p.getCodigo() %></td>
            <td><%= p.getDescricao() %></td>
            <td>R$ <%= p.getPreco() %></td>
            <td>
                <form action="<%= ctx %>/carrinho/remove" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= p.getCodigo() %>" />
                    <button type="submit" class="btn btn-delete">Remover</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <h3>Total: R$ <%= total %></h3>
</div>
</body>

</html>