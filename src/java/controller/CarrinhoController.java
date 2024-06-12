/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.CarrinhoDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class CarrinhoController extends HttpServlet {

    CarrinhoDAO cDAO = new CarrinhoDAO();
    UsuarioDAO uDAO = new UsuarioDAO();
    ProdutoDAO pDAO = new ProdutoDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        String nextPage = "/WEB-INF/jsp/carrinho.jsp";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario") && !cookie.getValue().equals("")) {
                    u = uDAO.pegarPorID(Integer.parseInt(cookie.getValue()));
                }
            }
        }
        if (!(u.getIdUsuario() == 0)) {
            List<Produto> produtos = cDAO.listarProdutos(u);
            Float valorTotal = 0.0f;
            for (int i = 0; i < produtos.size(); i++) {
                produtos.get(i).setImagemBase64(Base64.getEncoder().encodeToString(produtos.get(i).getImagem()));
                valorTotal += produtos.get(i).getValorFinal();
            }
            request.setAttribute("valorTotal", valorTotal);
            request.setAttribute("carrinho", produtos);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("./login");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Usuario u = new Usuario();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario") && !cookie.getValue().equals("")) {
                    u = uDAO.pegarPorID(Integer.parseInt(cookie.getValue()));
                }
            }
        }
        String url = request.getServletPath();
        if (url.equals("/excluir")) {
            cDAO.removerProduto(pDAO.pegarProdutoporID(Integer.parseInt(request.getParameter("item"))), cDAO.getCarrinho(u));
            response.sendRedirect("./carrinho");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
