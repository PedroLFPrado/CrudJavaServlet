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
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/produto/delete")
public class ProdutoDeleteServlet extends HttpServlet {
    private ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) dao.delete(Integer.valueOf(idStr));
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}
