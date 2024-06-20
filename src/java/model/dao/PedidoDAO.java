/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Pedido;
import model.bean.Produto;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class PedidoDAO {

    public List<Pedido> listPedidos(Usuario idUsuario) {
        List<Pedido> pedidos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM pedido WHERE usuario = ? ");
            stmt.setInt(1, idUsuario.getIdUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setUsuario(rs.getInt("usuario"));
                pedido.setEnderecoEntrega(rs.getInt("enderecoEntrega"));
                pedido.setDataPedido(rs.getDate("dataPedido"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<Pedido> lerPedido() {
        List<Pedido> pedidos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM pedido ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setUsuario(rs.getInt("usuario"));
                pedido.setEnderecoEntrega(rs.getInt("enderecoEntrega"));
                pedido.setDataPedido(rs.getDate("dataPedido"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public void create(Pedido p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO endereco(usuario, enderecoEntrega, dataPedido, valorTotal, status) values ( ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getUsuario());
            stmt.setInt(2, p.getEnderecoEntrega());
            stmt.setDate(3, p.getDataPedido());
            stmt.setFloat(4, p.getValorTotal());
            stmt.setString(5, p.getStatus());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void adicionarProduto(Pedido p, List<Produto> produtos) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            for (int i = 0; i < produtos.size(); i++) {
                stmt = conexao.prepareStatement("INSERT INTO produtoPedido (produto, pedido) values (?, ?) ");
                stmt.setInt(1, produtos.get(i).getIdProduto());
                stmt.setInt(2, p.getIdPedido());
                stmt.executeUpdate();
            }

            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void excluir(Pedido p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM pedido WHERE idPedido = ?");
            stmt.setInt(1, p.getIdPedido());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Produto> selecionarProdutos(Pedido p) {
        List<Produto> produtos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("SELECT p.* FROM produtoPedido AS pp JOIN pedido as ped ON pp.pedido = ped.idPedido WHERE ped.idPedido = ?");
            stmt.setInt(1, p.getIdPedido());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDesconto(rs.getFloat("desconto"));
                produto.setValor(rs.getFloat("valor"));
                produto.setValorFinal(rs.getFloat("valorFinal"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setImagem(rs.getBytes("imagem"));
                produto.setValidade(rs.getDate("validade"));
                produtos.add(produto);
            }
            
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return produtos;
    }
}
