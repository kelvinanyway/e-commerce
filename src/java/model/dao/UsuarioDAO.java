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
import java.util.Base64;
import model.bean.Usuario;

/**
 *
 * @author Senai
 */
public class UsuarioDAO {

    public int login(Usuario u) {
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

    public Usuario getUsuariobyid(int id) {
        Usuario u = new Usuario();
        if (id == -1) {
            return u;
        }
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setTelefone(rs.getString("telefone"));
                u.setCpf(rs.getString("cpf"));
                u.setData(rs.getDate("data"));
                u.setTipo(rs.getInt("tipo"));
                u.setFotodeperfil(rs.getBytes("fotoPerfil"));
                if (u.getFotodeperfil() != null) {
                    u.setFotodeperfilBase64(Base64.getEncoder().encodeToString(u.getFotodeperfil()));
                }

            } else {
                System.out.println("Usuario não localizado.");
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
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

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, telefone = ?, fotodeperfil = ? WHERE idUsuario = ?");

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTelefone());
            stmt.setBytes(5, u.getFotodeperfil());
            stmt.setInt(6, u.getIdUsuario());

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

            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, u.getIdUsuario());

            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
