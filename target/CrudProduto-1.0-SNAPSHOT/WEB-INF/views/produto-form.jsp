<%-- 
    Document   : produto-form
    Created on : 8 de set. de 2025, 14:03:33
    Author     : Pedro Lemos / Gustavo Henrique
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.crudproduto.model.Produto" %>
<%
    Produto produto = (Produto) request.getAttribute("produto");
    boolean edit = (produto != null && produto.getCodigo() != null);
    String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= edit ? "Editar" : "Novo" %> Produto</title>
    <link rel="stylesheet" href="<%= ctx %>/css/style.css">
</head>
<body>
<div class="container">
    <h1><%= edit ? "Editar" : "Novo" %> Produto</h1>
    <form action="<%= ctx %>/produto/form" method="post">
        <input type="hidden" name="codigo" value="<%= edit ? produto.getCodigo() : "" %>" />
        <label>Descrição:
            <input name="descricao" value="<%= edit ? produto.getDescricao() : "" %>" required/>
        </label>
        <label>Preço:
            <input type="number" step="0.01" name="preco" value="<%= edit ? produto.getPreco() : "" %>" required/>
        </label>
        <label>Quantidade:
            <input type="number" name="qtde" value="<%= edit ? produto.getQtde() : 0 %>" required/>
        </label>
        <button type="submit" class="btn btn-add">Salvar</button>
    </form>
    <a href="<%= ctx %>/produtos">Voltar</a>
</div>
</body>

</html>