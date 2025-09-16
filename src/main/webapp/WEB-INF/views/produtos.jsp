<%-- 
    Document   : produtos
    Created on : 8 de set. de 2025, 13:57:40
    Author     : Pedro Lemos / Gustavo Henrique
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.crudproduto.model.Produto" %>
<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
    String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" href="<%= ctx %>/css/style.css">
</head>

<body>
<div class="container">
    <h1>Produtos</h1>
    <a href="<%= ctx %>/produto/form" class="btn btn-add">Novo Produto</a>
    &nbsp;|&nbsp;
    <a href="<%= ctx %>/carrinho/view">Ver Carrinho</a>
    
    <table>
        <tr>
            <th>Código</th><th>Descrição</th><th>Preço</th><th>Qtde</th><th>Ações</th>
        </tr>
        <% if (produtos != null) { for (Produto p : produtos) { %>
        <tr>
            <td><%= p.getCodigo() %></td>
            <td><%= p.getDescricao() %></td>
            <td>R$ <%= p.getPreco() %></td>
            <td><%= p.getQtde() %></td>
            <td>
                <form action="<%= ctx %>/carrinho/add" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= p.getCodigo() %>" />
                    <button type="submit" class="btn btn-add">Adicionar</button>
                </form>
                <a href="<%= ctx %>/produto/form?id=<%= p.getCodigo() %>" class="btn btn-edit">Editar</a>
                <form action="<%= ctx %>/produto/delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= p.getCodigo() %>" />
                    <button type="submit" class="btn btn-delete">Remover</button>
                </form>
            </td>
        </tr>
        <% } } %>
    </table>
</div>
</body>
</html>