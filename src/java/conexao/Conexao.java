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
        private static final String url = "jdbc:mysql://localhost:3306/mercado88";
    private static final String user = "root";
    private static final String senha = "";

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
