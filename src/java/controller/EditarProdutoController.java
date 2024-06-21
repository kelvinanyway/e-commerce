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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Produto;
import model.dao.ProdutoDAO;

/**
 *
 * @author Senai
 */
public class EditarProdutoController extends HttpServlet {

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
        String nextPage = "/WEB-INF/jsp/editarProduto.jsp";
       //faz a leitura dos items cadastrdados e retotrna na página
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

        String url = request.getServletPath();
        Produto p = new Produto();

       //função para o administrador editar os produtos
        if (url.equals("/excluirProduto")) {
            p = pDAO.pegarProdutoporID(Integer.parseInt(request.getParameter("excluir")));
            pDAO.deletar(p);

        } else if (url.equals("/atualizarNomeProduto")) {
            p = pDAO.pegarProdutoporID(Integer.parseInt(request.getParameter("atualizarNomeProduto")));
            p.setNome(request.getParameter("nome"));
            pDAO.update(p);

        } else if (url.equals("/atualizarValor")) {
            p = pDAO.pegarProdutoporID(Integer.parseInt(request.getParameter("atualizarValor")));
            p.setValor(Float.parseFloat(request.getParameter("valor")));
            pDAO.update(p);

        } else if (url.equals("/atualizarDesconto")) {
            p = pDAO.pegarProdutoporID(Integer.parseInt(request.getParameter("atualizarDesconto")));
            p.setDesconto(Float.parseFloat(request.getParameter("desconto")));
            pDAO.update(p);

        } else if (url.equals("/atualizarQuantidade")) {
            p = pDAO.pegarProdutoporID(Integer.parseInt(request.getParameter("atualizarQuantidade")));
            p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            pDAO.update(p);
        }
        response.sendRedirect("./editarProduto");
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
