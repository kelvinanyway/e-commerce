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
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class UsuarioDAO {
    
    public int login (Usuario u){
          int idUsuario = -1;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

            stmt = conexao.prepareStatement(query);
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());

            rs = stmt.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUsuario;
    }

    public void create(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha, data, cpf, telefone) values (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setDate(4, u.getData());
            stmt.setString(5, u.getCpf());
            stmt.setString(6, u.getTelefone());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE usuario SET idUsuario = ?, nome = ?, email = ?, senha = ?, telefone = ?");
            stmt.setInt(1, u.getIdUsuario());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getTelefone());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(Usuario u) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE usuario SET idUsuario = ?, nome = ?, email = ?, senha = ?,data = ?, cpf = ?, telefone = ?");
            stmt.setInt(1, u.getIdUsuario());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getTelefone());
            
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
