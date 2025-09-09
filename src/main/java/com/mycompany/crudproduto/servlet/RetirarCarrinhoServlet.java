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

@WebServlet("/carrinho/remove")
public class RetirarCarrinhoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            Integer id = Integer.valueOf(idStr);
            HttpSession session = req.getSession();
            List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
            if (carrinho != null) {
                // remove a primeira ocorrência com esse codigo
                carrinho.removeIf(p -> p.getCodigo() != null && p.getCodigo().equals(id));
            }
        }
        resp.sendRedirect(req.getContextPath() + "/carrinho/view");
    }
}
