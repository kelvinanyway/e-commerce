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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.CarrinhoProduto;
import model.bean.Endereco;
import model.bean.Pedido;
import model.bean.Produto;
import model.bean.Usuario;
import model.dao.CarrinhoDAO;
import model.dao.EnderecoDAO;
import model.dao.PedidoDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "PagamentoController", urlPatterns = {"/PagamentoController"})
public class PagamentoController extends HttpServlet {

    EnderecoDAO eDAO = new EnderecoDAO();
    UsuarioDAO uDAO = new UsuarioDAO();
    CarrinhoDAO cDAO = new CarrinhoDAO();
    PedidoDAO pDAO = new PedidoDAO();
    
    

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
        String nextPage = "/WEB-INF/jsp/pagamento.jsp";
        Endereco e = new Endereco();

        e.setCidade(request.getParameter("cidade"));
        e.setBairro(request.getParameter("bairro"));
        e.setEstado(request.getParameter("estado"));
        e.setRua(request.getParameter("endereco"));
        e.setNumero(Integer.parseInt(request.getParameter("numero")));
        e.setCep(request.getParameter("cep"));
        int idEndereco = eDAO.create(e);
        Cookie cookie = new Cookie("idEndereco", Integer.toString(idEndereco));
        response.addCookie(cookie);

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

        if (url.equals("/finalizarPedido")) {
            int idEndereco = 0;
            Cookie[] cookies = request.getCookies();
            Usuario u = new Usuario();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("idEndereco")) {
                    idEndereco = Integer.parseInt(cookie.getValue());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("usuario") && !cookie.getValue().equals("")) {
                    u = uDAO.pegarPorID(Integer.parseInt(cookie.getValue()));
                }
            }
            Endereco e = eDAO.selecionarPorID(idEndereco);
            Pedido p = new Pedido();

            p.setDataPedido();
            List<Produto> produtos = cDAO.listarProdutos(u);
            Float valorFinal = 0.0f;
            for (int i = 0; i < produtos.size(); i++) {
                 List<CarrinhoProduto> produtoquantidade = cDAO.selecionarQuantidadeProduto(cDAO.selecionarCarrinho(u));
                valorFinal += produtos.get(i).getValorFinal()* produtoquantidade.get(i).getQuantidade();
            }
            p.setUsuario(u.getIdUsuario());
            p.setEnderecoEntrega(e.getIdEndereco());
            p.setValorTotal(valorFinal + 10.0f);
            
           cDAO.listarProdutos(u);
           pDAO.create(p);
           cDAO.excluirCarrinho(u);
           response.sendRedirect("./pedidoFinalizado");
        } else {
            processRequest(request, response);
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
