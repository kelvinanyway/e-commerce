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
import java.util.Base64;
import java.util.List;
import model.bean.Produto;

/**
 *
 * @author Senai
 */
public class ProdutoDAO {

    public List<Produto> read() {
        List<Produto> produtos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setValorFinal(rs.getFloat("valorFinal"));
                produto.setDesconto(rs.getFloat("desconto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValidade(rs.getDate("validade"));
                produto.setImagem(rs.getBytes("imagem"));
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

    public Produto pegarProdutoporID(int id) {
        Produto produto = new Produto();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE idProduto = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setValorFinal(rs.getFloat("valorFinal"));
                produto.setDesconto(rs.getFloat("desconto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValidade(rs.getDate("validade"));
                produto.setImagem(rs.getBytes("imagem"));
                produto.setImagemBase64(Base64.getEncoder().encodeToString(produto.getImagem()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }

    public List<Produto> pegarPorNome(String nome) {

        List<Produto> produtos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setValorFinal(rs.getFloat("valorFinal"));
                produto.setDesconto(rs.getFloat("desconto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setValidade(rs.getDate("validade"));
                produto.setImagem(rs.getBytes("imagem"));
                produto.setImagemBase64(Base64.getEncoder().encodeToString(produto.getImagem()));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void create(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produto( nome, valor, desconto, quantidade, validade, imagem) values ( ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, p.getNome());
            stmt.setFloat(2, p.getValor());
            stmt.setFloat(3, p.getDesconto());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDate(5, p.getValidade());
            stmt.setBytes(6, p.getImagem());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void update(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE produto SET nome = ?, valor = ?, desconto = ?, quantidade = ?, validade = ?, imagem = ? WHERE idProduto = ? ");
            stmt.setString(1    , p.getNome());
            stmt.setFloat(2, p.getValor());
            stmt.setFloat(3, p.getDesconto());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDate(5, p.getValidade());
            stmt.setBytes(6, p.getImagem());
            stmt.setInt(7, p.getIdProduto());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deletar(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, p.getIdProduto());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
