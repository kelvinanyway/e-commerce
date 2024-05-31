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
import model.bean.Categoria;

/**
 *
 * @author Senai
 */
public class CategoriaDAO {
    
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM categoria");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Categoria categoriaAtual = new Categoria();
                categoriaAtual.setIdCategoria(rs.getInt("idCategoria"));
                categoriaAtual.setNome(rs.getString("nome"));
                
                categorias.add(categoriaAtual);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return categorias;
    
    }
    public Categoria pegarPorID(int id) {
        Categoria c = new Categoria();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categoria WHERE idCategoria = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdCategoria(id);
                c.setNome(rs.getString("nome"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Categoria pegarPorNome(String nome) {
        Categoria c = new Categoria();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categoria WHERE nome = ?");
            stmt.setString(1, c.getNome());

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNome(nome);
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Categoria readByNome(Categoria c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categoria WHERE nome = ?");
            stmt.setString(1, c.getNome());

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setIdCategoria(rs.getInt("idCategoria"));
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
