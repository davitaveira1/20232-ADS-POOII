/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class conexao {

    private static Connection conn = null;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/poo2-teste", "root", "");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro: "+ e);
            }
        }
        return conn;
    }

}
