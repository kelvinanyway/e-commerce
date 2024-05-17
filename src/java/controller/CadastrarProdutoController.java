/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.Produto;
import model.dao.ProdutoDAO;

/**
 *
 * @author Senai
 */
public class CadastrarProdutoController extends HttpServlet {

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
        String nextPage = "/WEB-INF/jsp/cadastrarProduto.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
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
        if (url.equals("/addProduto")) {
            Produto p = new Produto();
            ProdutoDAO pDao = new ProdutoDAO();
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            System.out.println(request.getParameter("valor"));
            p.setValor(Float.parseFloat(request.getParameter("valor")));
            p.setDesconto(Float.parseFloat(request.getParameter("desconto")));
            Part filePart = request.getPart("imagem");
            InputStream iStream = filePart.getInputStream();
            ByteArrayOutputStream byteA = new ByteArrayOutputStream();
            byte[] img = new byte[4096];
            int byteRead = -1;
            while ((byteRead = iStream.read(img)) != -1) {
                byteA.write(img, 0, byteRead);
            }
            byte[] imgBytes = byteA.toByteArray();
            //Imagem imagem = new Imagem();
            //imagem.setProduto(pDao.create(p));
            //imagem.setImagem(imgBytes);
            //ImagemDAO imgDAO = new ImagemDAO();
            //imgDAO.insertImagem(imagem);
            //response.sendRedirect("./cadastroproduto"); 

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
