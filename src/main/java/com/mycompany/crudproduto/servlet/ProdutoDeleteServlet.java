package com.mycompany.crudproduto.servlet;

import com.mycompany.crudproduto.dao.ProdutoDAO;
import com.mycompany.crudproduto.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/produto/delete")
public class ProdutoDeleteServlet extends HttpServlet {
    private ProdutoDAO dao = new ProdutoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            Integer id = Integer.valueOf(idStr);

            // remove do banco
            dao.delete(id);

            // remove também do carrinho da sessão
            HttpSession session = req.getSession();
            List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
            if (carrinho != null) {
                carrinho.removeIf(p -> p.getCodigo() != null && p.getCodigo().equals(id));
            }
        }
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }
}