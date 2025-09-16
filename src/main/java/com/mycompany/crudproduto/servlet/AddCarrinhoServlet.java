package com.mycompany.crudproduto.servlet;

import com.mycompany.crudproduto.dao.ProdutoDAO;
import com.mycompany.crudproduto.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carrinho/add")
public class AddCarrinhoServlet extends HttpServlet {
    private ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            Integer id = Integer.valueOf(idStr);
            Produto p = dao.findById(id);
            if (p != null) {
                HttpSession session = req.getSession();
                List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
                if (carrinho == null) {
                    carrinho = new ArrayList<>();
                    session.setAttribute("carrinho", carrinho);
                }

                // cada adição é uma "unidade" do produto
                Produto copy = new Produto();
                copy.setCodigo(p.getCodigo());
                copy.setDescricao(p.getDescricao());
                copy.setPreco(p.getPreco());
                copy.setQtde(1); 
                carrinho.add(copy);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}