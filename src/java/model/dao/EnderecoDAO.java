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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.Endereco;

/**
 *
 * @author Senai
 */
public class EnderecoDAO {

    public Endereco selecionarPorID(int id) {
        Endereco endereco = new Endereco();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM endereco WHERE idEndereco = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {

                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setRua(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    public List<Endereco> read() {
        List<Endereco> enderecos = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM endereco ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setIdEndereco(rs.getInt("idEndereco"));
                endereco.setCep(rs.getString("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setRua(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
                enderecos.add(endereco);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    public int create(Endereco end) {
        int id = 0;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO endereco( cep, rua, bairro, cidade, estado, numero) values (?, ?, ?, ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, end.getCep());
            stmt.setString(2, end.getRua());
            stmt.setString(3, end.getBairro());
            stmt.setString(4, end.getCidade());
            stmt.setString(5, end.getEstado());
            stmt.setInt(6, end.getNumero());

            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);

                }
            }
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(end.getCep());
        }
        return id;

    }

    public void update(Endereco end) {
        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE endereco SET cep = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, estado = ?, numero = ? WHERE idEndereco = ?");

            stmt.setInt(1, end.getIdEndereco());
            stmt.setString(2, end.getCep());
            stmt.setString(3, end.getRua());
            stmt.setString(4, end.getBairro());
            stmt.setString(5, end.getCidade());
            stmt.setString(6, end.getEstado());
            stmt.setInt(7, end.getNumero());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
