/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class PerfilController extends HttpServlet {

    UsuarioDAO uDAO = new UsuarioDAO();

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
        String nextPage = "/WEB-INF/jsp/perfil.jsp";

        Usuario usuario = new Usuario();

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("usuario")) {
                usuario = uDAO.pegarPorID(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
        }
        if (usuario.getIdUsuario() == 0) {
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
        String url = request.getServletPath();
        Cookie[] cookies = request.getCookies();
        int idUsuario = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("usuario")) {
                idUsuario = Integer.parseInt(cookie.getValue());
            }
        }
        //função para o cliente editar suas informações
        if (url.equals("/atualizarNome")) {
            uDAO.update(idUsuario, request.getParameter("nome"), "nome");
        } else if (url.equals("/atualizarEmail")) {
            uDAO.update(idUsuario, request.getParameter("email"), "email");
        } else if (url.equals("/atualizarSenha")) {
            uDAO.update(idUsuario, request.getParameter("senha"), "senha");
        } else if (url.equals("/atualizarTelefone")) {
            uDAO.update(idUsuario, request.getParameter("telefone"), "telefone");
        } else if (url.equals("/sair")) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        response.sendRedirect("./perfil");
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
