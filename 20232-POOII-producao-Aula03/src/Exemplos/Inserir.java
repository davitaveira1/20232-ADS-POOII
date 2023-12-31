/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Inserir {
    
    public static void main(String[] args) {
        
        Connection conn=null;
        PreparedStatement pst=null;
        
        conn = conexao.getConnection();        
        
        try {
            pst = conn.prepareStatement("insert into alunos "
                    + "set nome=?");
            pst.setString(1, "Davi Taveira");
            int linha = pst.executeUpdate();
            if(linha>0){
                System.out.println("SQL executado com sucesso!");
            }else{
                System.out.println("SQL não executado!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro:"+ ex);
        }     
        
    }
    
}
