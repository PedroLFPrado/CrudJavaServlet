package com.mycompany.crudproduto.servlet;

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
                // remove apenas a PRIMEIRA ocorrência com esse código
                for (int i = 0; i < carrinho.size(); i++) {
                    Produto p = carrinho.get(i);
                    if (p.getCodigo() != null && p.getCodigo().equals(id)) {
                        carrinho.remove(i);
                        break; // sai depois de remover UM item
                    }
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/carrinho/view");
    }
}