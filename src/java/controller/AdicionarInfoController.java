/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.CarrinhoDAO;
import model.dao.EnderecoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class AdicionarInfoController extends HttpServlet {

    Produto p = new Produto();

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

        response.setContentType("text/html;charset=UTF-8");
        CarrinhoDAO cDAO = new CarrinhoDAO();
        Usuario u = new Usuario();
        UsuarioDAO uDao = new UsuarioDAO();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario")) {
                    u = uDao.pegarPorID(Integer.parseInt(cookie.getValue()));
                }
            }
        }
        List<Produto> produtos = new ArrayList();
        if (u.getIdUsuario() > 0) {
            produtos = cDAO.listarProdutos(u);
        }
        System.out.println("p" + produtos.size());

        if (produtos.size() < 1) {
            response.sendRedirect("./carrinho");
        } else {
            String url = request.getServletPath();
            if (url.equals("/finalizarEndereco")) {
                String nextPage = "/WEB-INF/jsp/pagamento.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            } else {
                String nextPage = "/WEB-INF/jsp/adicionarInfo.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
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
        request.setCharacterEncoding("UTF-8");

        String url = request.getServletPath();
        if (url.equals("/finalizarEndereco")) {

            Endereco e = new Endereco();
            EnderecoDAO eDAO = new EnderecoDAO();

            e.setCep(Integer.parseInt(request.getParameter("cep")));
            e.setRua(request.getParameter("endereco"));
            e.setBairro(request.getParameter("bairro"));
            e.setCidade(request.getParameter("cidade"));
            e.setBairro(request.getParameter("bairro"));
            e.setCidade(request.getParameter("cidade"));
            e.setEstado(request.getParameter("estado"));
            e.setNumero(Integer.parseInt(request.getParameter("numero")));

            int id = eDAO.create(e);
            request.setAttribute("idEndereco", id);
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
