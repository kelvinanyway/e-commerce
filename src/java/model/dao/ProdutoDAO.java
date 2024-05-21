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
                produto.setDesconto(rs.getFloat("desconto"));
                produto.setValorFinal(rs.getFloat("valorFinal"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValidade(rs.getDate("validade"));
                produto.setImagem(rs.getBytes("imagem"));

            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void create(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produto( nome, valor, desconto, valorFinal, descricao, validade, imagem) values ( ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, p.getNome());
            stmt.setFloat(2, p.getValor());
            stmt.setFloat(3, p.getDesconto());
            stmt.setFloat(4, p.getValorFinal());
            stmt.setString(5, p.getDescricao());
            stmt.setDate(6, p.getValidade());
            stmt.setBytes(7, p.getImagem());

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

            stmt = conexao.prepareStatement("UPDATE produto SET idProduto = ?, nome = ?, valor = ?, desconto = ?, valorFinal = ?, desconto = ?,descricao = ?,validade = ?, imagem = ? ");
            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setFloat(4, p.getDesconto());
            stmt.setFloat(5, p.getValorFinal());
            stmt.setString(6, p.getDescricao());
            stmt.setDate(7, p.getValidade());
            stmt.setBytes(8, p.getImagem());
            ;

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
