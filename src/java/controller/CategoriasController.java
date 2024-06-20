/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Categoria;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.CarrinhoDAO;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class CategoriasController extends HttpServlet {

    ProdutoDAO pDAO = new ProdutoDAO();
    CategoriaDAO catDAO = new CategoriaDAO();
    UsuarioDAO uDAO = new UsuarioDAO();
    CarrinhoDAO cDAO = new CarrinhoDAO();

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
        String nextPage = "/WEB-INF/jsp/categoria.jsp";

        List<Produto> produtos = pDAO.lerProduto();
        for (int i = 0; i < produtos.size(); i++) {
            produtos.get(i).setImagemBase64(Base64.getEncoder().encodeToString(produtos.get(i).getImagem()));
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        request.setAttribute("produtos", produtos);
        dispatcher.forward(request, response);
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

        String url = request.getServletPath();
        String nextPage = "/WEB-INF/jsp/categoria.jsp";
        if (url.equals("/search")) {

            List<Produto> produtos = null;
            List<String> categorias = new ArrayList();

            String busca = request.getParameter("s");
            produtos = pDAO.pegarPorNome(busca);

            if (produtos.size() > 0) {
                for (int i = 0; i < produtos.size(); i++) {

                    produtos.get(i).setImagemBase64(Base64.getEncoder().encodeToString(produtos.get(i).getImagem()));

                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            request.setAttribute("produtos", produtos);
            dispatcher.forward(request, response);

        } else {
            processRequest(request, response);
        }
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
        Usuario u = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario") && !cookie.getValue().equals("")) {
                    u = uDAO.pegarPorID(Integer.parseInt(cookie.getValue()));
                }
            }
        }

        String url = request.getServletPath();
        if (url.equals("/adicionacarrinho")) {
            int idProduto = Integer.parseInt(request.getParameter("produtoSelecionado"));
            if (u != null) {       
               cDAO.addProduto(pDAO.pegarProdutoporID(idProduto), cDAO.getCarrinho(u));
               response.sendRedirect("./categorias");
            } else {
                response.sendRedirect("./login");
            }
            
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
