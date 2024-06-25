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
import model.bean.Carrinho;
import model.bean.CarrinhoProduto;
import model.bean.Produto;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {

    public void create(Carrinho c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinho(produto, carrinho)values(?,?)");
            //stmt.setInt(1, c.getProduto());
            //stmt.setInt(2, c.getCarrinho());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    public void delete(Carrinho c){
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE carrinho = ?");
        stmt.setInt(1, c.getIdCarrinho());
       
        
        stmt.close();
        conexao.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
     */
    public CarrinhoProduto selecionarCarrinhoProduto(int id) {
        CarrinhoProduto carrinhoproduto = new CarrinhoProduto();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM carrinhoproduto WHERE idCarrinhoProduto = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                carrinhoproduto.setIdCarrinhoProduto(rs.getInt("idCarrinhoProduto"));
                carrinhoproduto.setCarrinho(rs.getInt("carrinho"));
                carrinhoproduto.setProduto(rs.getInt("produto"));
                carrinhoproduto.setQuantidade(rs.getInt("quantidade"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinhoproduto;
    }

    public boolean adicionarProduto(Produto p, Carrinho c) {
        boolean produtoInserido = false;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            List<CarrinhoProduto> carrinhoprodutos = new ArrayList();

            stmt = conexao.prepareStatement("SELECT * FROM carrinhoproduto WHERE carrinho = ?");
            stmt.setInt(1, c.getIdCarrinho());

            ResultSet rs = stmt.executeQuery();
            int quantidade = 0;
            stmt = conexao.prepareStatement("select * from carrinhoproduto WHERE carrinho = ?");
            stmt.setInt(1, c.getIdCarrinho());

            ResultSet rs1 = stmt.executeQuery();

            while (rs1.next()) {
                quantidade += rs1.getInt("quantidade");
            }
            while (rs.next()) {
                CarrinhoProduto carrinhoproduto = new CarrinhoProduto();
                carrinhoproduto.setIdCarrinhoProduto(rs.getInt("idCarrinhoProduto"));
                carrinhoproduto.setProduto(rs.getInt("produto"));
                carrinhoproduto.setCarrinho(rs.getInt("carrinho"));
                carrinhoproduto.setQuantidade(rs.getInt("quantidade"));

                if (rs.getInt("produto") == p.getIdProduto()) {

                    if (quantidade < 10) {
                        stmt = conexao.prepareStatement("UPDATE carrinhoproduto SET quantidade = ? WHERE idCarrinhoProduto = ?");
                        stmt.setInt(1, carrinhoproduto.getQuantidade() + 1);
                        stmt.setInt(2, carrinhoproduto.getIdCarrinhoProduto());
                        stmt.executeUpdate();
                        produtoInserido = true;
                        return produtoInserido;
                    }

                }
                carrinhoprodutos.add(carrinhoproduto);
            }
            if (quantidade >= 10) {
                return produtoInserido;
            }

            stmt = conexao.prepareStatement("INSERT INTO carrinhoproduto (carrinho, produto, quantidade) VALUES (?, ?, 1)");
            stmt.setInt(1, c.getIdCarrinho());
            stmt.setInt(2, p.getIdProduto());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    public Carrinho selecionarCarrinho(Usuario u) {
        Carrinho c = new Carrinho();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM carrinho WHERE usuario = ?");
            stmt.setInt(1, u.getIdUsuario());

            rs = stmt.executeQuery();
            if (rs.next()) {
                c.setIdCarrinho(rs.getInt("idCarrinho"));
                c.setUsuario(rs.getInt("usuario"));

            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void alterarQuantidadeProduto(CarrinhoProduto cp) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE carrinhoproduto SET quantidade = ? WHERE idCarrinhoProduto = ?");
            stmt.setInt(1, cp.getQuantidade());
            stmt.setInt(2, cp.getIdCarrinhoProduto());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CarrinhoProduto> selecionarQuantidadeProduto(Carrinho c) {
        List<CarrinhoProduto> carrinhoprodutos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM carrinhoProduto WHERE carrinho = ?");
            stmt.setInt(1, c.getIdCarrinho());

            rs = stmt.executeQuery();
            while (rs.next()) {
                CarrinhoProduto carrinhoproduto = new CarrinhoProduto();
                carrinhoproduto.setIdCarrinhoProduto(rs.getInt("idCarrinhoproduto"));
                carrinhoproduto.setCarrinho(rs.getInt("carrinho"));
                carrinhoproduto.setProduto(rs.getInt("produto"));
                carrinhoproduto.setQuantidade(rs.getInt("quantidade"));
                carrinhoprodutos.add(carrinhoproduto);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrinhoprodutos;
    }

    /* public void addProduto(Produto p, Carrinho c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinhoproduto (carrinho, produto) VALUES (?, ?)");
            stmt.setInt(1, c.getIdCarrinho());
            stmt.setInt(2, p.getIdProduto());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */
    public void removerProduto(Produto p, Carrinho c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinhoproduto WHERE carrinho = ? AND produto = ?");
            stmt.setInt(1, c.getIdCarrinho());
            stmt.setInt(2, p.getIdProduto());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos(Usuario u) {
        List<Produto> produtos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT p.* FROM carrinhoProduto AS cp JOIN produto AS p ON cp.produto = p.idProduto"
                    + " JOIN carrinho AS c ON cp.carrinho = c.idCarrinho JOIN usuario AS u ON c.usuario = u.idUsuario WHERE u.idUsuario = ?");
            stmt.setInt(1, u.getIdUsuario());

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValor(rs.getFloat("valor"));
                p.setValorFinal(rs.getFloat("valorFinal"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setImagem(rs.getBytes("imagem"));
                p.setValidade(rs.getDate("validade"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public Carrinho pegarCarrinho(Usuario u) {
        Carrinho c = new Carrinho();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM carrinho WHERE usuario = ?");
            stmt.setInt(1, u.getIdUsuario());

            rs = stmt.executeQuery();
            if (rs.next()) {
                c.setIdCarrinho(rs.getInt("idCarrinho"));
                c.setUsuario(rs.getInt("usuario"));
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void excluirProdutoCarrinho(CarrinhoProduto cp) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinhoproduto WHERE carrinho = ? ");
            stmt.setInt(1, cp.getCarrinho());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluirCarrinho(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinhoProduto WHERE carrinho = ?");
            stmt.setInt(1, u.getIdUsuario());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
