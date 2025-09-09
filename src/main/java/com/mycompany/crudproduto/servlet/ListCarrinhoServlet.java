/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.crudproduto.servlet;

/**
 *
 * @author Pedro Lemos / Gustavo Henrique
 */


import com.mycompany.crudproduto.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/carrinho/view")
public class ListCarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
        double total = 0.0;
        if (carrinho != null) {
            for (Produto p : carrinho) {
                total += (p.getPreco() == null ? 0.0 : p.getPreco());
            }
        }
        req.setAttribute("total", total);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/carrinho.jsp");
        rd.forward(req, resp);
    }
}
