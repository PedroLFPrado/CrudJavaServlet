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

@WebServlet({"/produto/form", "/produto/form/*"})
public class ProdutoFormServlet extends HttpServlet {
    private ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            Integer id = Integer.valueOf(idStr);
            Produto p = dao.findById(id);
            req.setAttribute("produto", p);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/produto-form.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("codigo");
        Produto p = new Produto();
        if (idStr != null && !idStr.isEmpty()) p.setCodigo(Integer.valueOf(idStr));
        p.setDescricao(req.getParameter("descricao"));
        p.setPreco(Double.valueOf(req.getParameter("preco")));
        p.setQtde(Integer.valueOf(req.getParameter("qtde")));
        dao.save(p);
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}
