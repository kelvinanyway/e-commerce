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
import model.bean.Endereco;
import model.bean.Pedido;
import model.bean.PedidoProduto;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.PedidoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
public class HistoricoPedidoController extends HttpServlet {

    PedidoDAO pDAO = new PedidoDAO();
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
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Usuario u = new Usuario();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario") && !cookie.getValue().equals("")) {
                    u = uDAO.pegarPorID(Integer.parseInt(cookie.getValue()));
                }
            }
        }
        //verifica se o id do usuario e faz a listagem de quantidade e produtos
        if (!(u.getIdUsuario() == 0)) {
            List<Pedido> pedidos = pDAO.lerPedidosUsuario(u);
            request.setAttribute("pedidos", pedidos);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/HistoricoPedidos.jsp");
            rd.forward(request, response);

        } else {
            // caso o usuario nao esteja em sua conta, ele irá pra tela de login
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
        Pedido p = new Pedido();
        if (url.equals("/cancelarPedido")) {
            p = pDAO.pegarPedidoPorId(Integer.parseInt(request.getParameter("cancelarPedido")));
            pDAO.excluirPedido(p);
             response.sendRedirect("./historicoPedidos");
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
