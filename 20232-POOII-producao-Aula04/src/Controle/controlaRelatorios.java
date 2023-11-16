/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import db.conexao;

/**
 *
 * @author Davi
 */
public class controlaRelatorios {
    
    Connection conn = conexao.getConnection();
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public void relatorio1() {

        try {

            st = conn.createStatement();
            rs = st.executeQuery("select * from alunos where codigo=5");
   
            URL arquivo = getClass().getResource("/relatorios/relatorioExemplo.jasper");
            //JOptionPane.showMessageDialog(null, "Arquivo: " + arquivo);

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);

            //inserindo parâmetro no relatório
            Map<String, Object> params = new HashMap<String, Object>();

            //resgate da chave userLogadoSistema
            //String userLogadoSistema = System.getProperty("userLogadoSistema");            
            //params.put("userLogado",userLogadoSistema);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, params, jrRS);
            JasperViewer.viewReport(print);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }    
    
}
