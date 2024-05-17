/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Produto;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

/**
 *
 * @author Senai
 */
public class ProdutoDAO {

    public void create(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produto( idProduto, nome, valor, desconto, valorFinal, descricao, validade) values (?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setFloat(4, p.getDesconto());
            stmt.setFloat(5, p.getValorFinal());
            stmt.setString(6, p.getDescricao());
            stmt.setDate(7, p.getValidade());

            stmt.close();
            stmt.executeUpdate();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void update(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE produto SET idProduto = ?, nome = ?, valor = ?, desconto = ?, valorFinal = ?, desconto = ?,descricao = ?,validade = ? ");
            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setFloat(4, p.getDesconto());
            stmt.setFloat(5, p.getValorFinal());
            stmt.setString(6, p.getDescricao());
            stmt.setDate(7, p.getValidade());
            ;

            stmt.close();
            stmt.executeUpdate();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deletar(Produto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE produto SET idProduto = ?, nome = ?, valor = ?, desconto = ?, valorFinal = ?, descricao = ? validade = ?");
            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setFloat(4, p.getDesconto());
            stmt.setFloat(5, p.getValorFinal());
            stmt.setString(6, p.getDescricao());
            stmt.setDate(7, p.getValidade());

            stmt.close();
            conexao.close();
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
