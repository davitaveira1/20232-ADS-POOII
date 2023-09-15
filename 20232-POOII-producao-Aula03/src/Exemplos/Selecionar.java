/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.conexao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class Selecionar {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        conn = conexao.getConnection();
        try {
            pst = conn.prepareStatement("select * from alunos "
                    + "where codigo=1");
            //pst.setInt(1, 1);

            rs = pst.executeQuery();
            
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

    }

}
