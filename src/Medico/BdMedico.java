/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class BdMedico extends bd.Bd {
    public BdMedico() {
        try {
            conexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    public void insere(Medico medico) {
        String sql = "insert into Medico (Nome,CRM,CPF,RG,End_Rua,End_Comp,End_Bairro,End_Cidade,End_UF,End_CEP,Observacoes,Foto) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCRM());
            ps.setString(3, medico.getCPF());
            ps.setString(4, medico.getRG());
            ps.setString(5, medico.getEnd_Rua());
            ps.setString(6, medico.getEnd_Comp());
            ps.setString(7, medico.getEnd_Bairro());
            ps.setString(8, medico.getEnd_Cidade());
            ps.setString(9, medico.getEnd_UF());
            ps.setString(10, medico.getEnd_CEP());
            ps.setString(11, medico.getObservacoes());
            ps.setBytes(12, medico.getFoto());
            ps.setString(13, medico.getTelefone1());
            ps.setString(14, medico.getTelefone2());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    
    public void atualiza(Medico medico) {
        String sql = "update Medico set Nome=?, RG=?, End_Rua=?, End_CEP=?, End_Cidade=?, End_Bairro=?, End_UF=?, End_Comp=?, CRM=?, foto=?, Telefone1=?, Telefone2=? where CPF=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getRG());
            ps.setString(3, medico.getEnd_Rua());
            ps.setString(4, medico.getEnd_CEP());
            ps.setString(5, medico.getEnd_Cidade());
            ps.setString(6, medico.getEnd_Bairro());
            ps.setString(7, medico.getEnd_UF());
            ps.setString(8, medico.getEnd_Comp());
            ps.setString(9, medico.getCRM());
            ps.setBytes(10, medico.getFoto());
            ps.setString(11, medico.getTelefone1());
            ps.setString(12, medico.getTelefone2());
            ps.setString(13, medico.getCPF());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    public List relatorio(String CPF) {
          String sql = "select nome,cpf,rg from Medico ORDER BY Nome";
            List lista = new ArrayList();
            try {
               PreparedStatement st = getCon().prepareStatement(sql);
               ResultSet rs = st.executeQuery();
               while (rs.next()) {
               Medico registro = new Medico();
               registro.setNome(rs.getString("Nome"));
               registro.setCPF(rs.getString("CPF"));
               registro.setRG(rs.getString("RG"));
               lista.add(registro);
               }
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
           }
            return lista;
        }
    
    public List pesquisa(String busca) {
            String sql = "select nome,cpf,rg from Medico where nome like '%"+busca+"%'";
            List lista = new ArrayList();
            try {
                Statement st = getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Medico registro = new Medico();
                    registro.setNome(rs.getString("Nome"));
                registro.setCPF(rs.getString("CPF"));
                registro.setRG(rs.getString("RG"));
                lista.add(registro);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
            return lista;
        }
    
    public Medico localiza(String CPF) {
        String sql = "select * from Medico where CPF=?";
       Medico registro = new Medico();
        try {
            PreparedStatement  ps = getCon().prepareStatement(sql);
            ps.setString(1, CPF);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                registro.setCodigo(rs.getInt("Codigo"));
                registro.setCRM(rs.getString("CRM"));
                registro.setNome(rs.getString("Nome"));
                registro.setCPF(rs.getString("CPF"));
                registro.setRG(rs.getString("RG"));
                registro.setEnd_Bairro(rs.getString("End_Bairro"));
                registro.setEnd_CEP(rs.getString("End_CEP"));
                registro.setEnd_Cidade(rs.getString("End_Cidade"));
                registro.setEnd_Comp(rs.getString("End_Comp"));
                registro.setEnd_Rua(rs.getString("End_Rua"));
                registro.setEnd_UF(rs.getString("End_UF"));
                
                registro.setFoto(rs.getBytes("foto"));
               
                
                
            }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
            return registro;

        }
    
}