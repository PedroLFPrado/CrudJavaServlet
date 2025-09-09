/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crudproduto.servlet;

/**
 *
 * @author Pedro Lemos / Gustavo Henrique
 */


import com.mycompany.crudproduto.dao.ProdutoDAO;
import com.mycompany.crudproduto.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoListServlet extends HttpServlet {
    private ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = dao.findAll();
        req.setAttribute("produtos", produtos);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/produtos.jsp");
        rd.forward(req, resp);
    }
}
