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
import model.bean.Endereco;
import model.bean.Pedido;
import model.bean.PedidoProduto;
import model.bean.Produto;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class PedidoDAO {

    public List<Pedido> lerPedidosUsuario(Usuario u) {
        List<Pedido> pedidos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM pedido WHERE usuario = ?");
            stmt.setInt(1, u.getIdUsuario());

            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setUsuario(rs.getInt("usuario"));
                p.setEnderecoEntrega(rs.getInt("enderecoEntrega"));
                p.setValorTotal(rs.getFloat("valorTotal"));
                p.setDataPedido(rs.getDate("dataPedido"));
                pedidos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return pedidos;
    }

    public Endereco selecionarEnderecoUsuario(Pedido p) {
        Endereco e = new Endereco();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM endereco WHERE idEndereco = ?");
            stmt.setInt(1, p.getEnderecoEntrega());

            rs = stmt.executeQuery();

            if (rs.next()) {
                e.setIdEndereco(rs.getInt("idEndereco"));
                e.setEstado(rs.getString("estado"));
                e.setCidade(rs.getString("cidade"));
                e.setCep(rs.getString("cep"));
                e.setBairro(rs.getString("bairro"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getInt("numero"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public List<PedidoProduto> selecionarProdutoPedido(Pedido ped) {
        List<PedidoProduto> listPp = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produtopedido WHERE pedido = ?");
            stmt.setInt(1, ped.getIdPedido());

            rs = stmt.executeQuery();

            while (rs.next()) {
                PedidoProduto pp = new PedidoProduto();
                pp.setIdProdutoPedido(rs.getInt("idProdutoPedido"));
                pp.setPedido(rs.getInt("pedido"));
                pp.setProduto(rs.getInt("produto"));
                pp.setQuantidade(rs.getInt("quantidade"));
                listPp.add(pp);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPp;
    }

    public List<Produto> selecionarProdutosDoPedido(Pedido ped) {
        List<Produto> produtos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT p.* FROM produtopedido as pp JOIN produto AS p ON pp.produto = p.idProduto JOIN pedido AS ped ON pp.pedido = ped.idPedido WHERE ped.idPedido = ?");
            stmt.setInt(1, ped.getIdPedido());

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValorFinal(rs.getFloat("valorFinal"));

                produtos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
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
                pedido.setStatus(rs.getInt("status"));
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

            stmt = conexao.prepareStatement("INSERT INTO pedido(usuario, enderecoEntrega, dataPedido, valorTotal, status) values ( ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getUsuario());
            stmt.setInt(2, p.getEnderecoEntrega());
            stmt.setDate(3, p.getDataPedido());
            stmt.setFloat(4, p.getValorTotal());
            stmt.setInt(5, p.getStatus());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void adicionarProduto(Pedido p, List<Produto> produtos) {
        if (produtos == null) {
            return;
        }

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            for (int i = 0; i < produtos.size(); i++) {
                stmt = conexao.prepareStatement("INSERT INTO produtoPedido (produto, pedido, quantidade) values (?, ?, ?) ");
                stmt.setInt(1, produtos.get(i).getIdProduto());
                stmt.setInt(2, p.getIdPedido());
                stmt.setInt(3, produtos.get(i).getQuantidade());
                stmt.executeUpdate();
            }

            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void excluirPedido(Pedido p) {
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

    public Pedido pegarPedidoPorId(int id) {
        Pedido pedido = new Pedido();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM pedido WHERE idPedido = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setUsuario(rs.getInt("usuario"));
                pedido.setEnderecoEntrega(rs.getInt("enderecoEntrega"));
                pedido.setDataPedido(rs.getDate("dataPedido"));
                pedido.setValorTotal(rs.getFloat("valorTotal"));
                pedido.setStatus(rs.getInt("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }
}
