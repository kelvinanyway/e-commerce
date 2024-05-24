/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Carrinho;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {

    public void create(Carrinho c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO carrinho(produto,carrinho)values(?,?)");
            stmt.setInt(1, c.getProduto());
            stmt.setInt(2, c.getCarrinho());

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
    public void update(Carrinho c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("UPDATE carrinho SET carrinho = ?, produto = ? WHERE idCarrinho = ?");
            stmt.setInt(1, c.getCarrinho());
            stmt.setInt(2, c.getProduto());
            stmt.setInt(3, c.getIdCarrinho());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Carrinho c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE carrinho WHERE idCarrinho = ?");
            stmt.setInt(1, c.getIdCarrinho());

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
