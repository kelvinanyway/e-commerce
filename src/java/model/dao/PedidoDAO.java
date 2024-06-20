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
import model.bean.Pedido;

/**
 *
 * @author Senai
 */
public class PedidoDAO {

    public List<Pedido> read() {
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
                pedido.setStatus(rs.getString("status"));
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

            stmt = conexao.prepareStatement("INSERT INTO endereco(usuario, enderecoEntrega, dataPedido, valorTotal, status) values ( ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getUsuario());
            stmt.setInt(2, p.getEnderecoEntrega());
            stmt.setDate(3, p.getDataPedido());
            stmt.setFloat(4, p.getValorTotal());
            stmt.setString(5, p.getStatus());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
