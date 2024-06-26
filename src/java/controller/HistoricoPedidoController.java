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

        List<Pedido> pedidos = pDAO.lerPedidosUsuario(u);
        List<List<Produto>> itensDoPedido = new ArrayList();
        List<List<PedidoProduto>> produtopedido = new ArrayList();
        List<Integer> qtdItens = new ArrayList();
        List<Endereco> enderecos = new ArrayList();
        pedidos.forEach((p) -> {
            List<Produto> produtos = pDAO.selecionarProdutosDoPedido(p);
            List<PedidoProduto> produtoPedido = pDAO.selecionarPedidoProduto(p);

            int quantidade = 0;
            for (int i = 0; i < produtos.size(); i++) {
                produtos.get(i).setImagemBase64(Base64.getEncoder().encodeToString(produtos.get(i).getImagem()));
            }
            for (int i = 0; i < produtoPedido.size(); i++) {
                quantidade += produtoPedido.get(i).getQuantidade();
            }
            itensDoPedido.add(produtos);
            produtopedido.add(produtoPedido);
            qtdItens.add(quantidade);
            enderecos.add(pDAO.selecionarEnderecoUsuario(p));
        });
        request.setAttribute("enderecos", enderecos);
        request.setAttribute("qtdItens", qtdItens);
        request.setAttribute("itensDoPedido", itensDoPedido);
        request.setAttribute("produtopedido", produtopedido);
        request.setAttribute("pedidos", pedidos);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/HistoricoPedidos.jsp");
        rd.forward(request, response);
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
        processRequest(request, response);
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
