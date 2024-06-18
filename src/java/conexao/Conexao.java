/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Senai
 */
public class Conexao {
        private static final String url = "jdbc:mysql://db4free.net:3306/mercadoecommerce?useSSL=false";
    private static final String user = "kelvinmercado";
    private static final String senha = "kelvinbaubau";

    public static Connection conectar() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
