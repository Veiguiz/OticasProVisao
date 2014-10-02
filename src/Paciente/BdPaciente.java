/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paciente;

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
public class BdPaciente extends bd.Bd {
    public BdPaciente() {
        try {
            conexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    public void insere(Paciente paciente) {
        String sql = "insert into Paciente (Nome,Apelido,CPF,RG,End_Rua,End_Comp,End_Bairro,End_Cidade,End_UF,End_CEP,DataNasc,Observacoes,Foto,Email) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getApelido());
            ps.setString(3, paciente.getCPF());
            ps.setString(4, paciente.getRG());
            ps.setString(5, paciente.getEnd_Rua());
            ps.setString(6, paciente.getEnd_Comp());
            ps.setString(7, paciente.getEnd_Bairro());
            ps.setString(8, paciente.getEnd_Cidade());
            ps.setString(9, paciente.getEnd_UF());
            ps.setString(10, paciente.getEnd_CEP());
            ps.setString(11,paciente.getDataNasc());
            ps.setString(12, paciente.getObservacoes());
            ps.setBytes(13, paciente.getFoto());
            ps.setString(14, paciente.getEmail());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    
    public void atualiza(Paciente paciente) {
        String sql = "update Paciente set Nome=?, RG=?, End_Rua=?, End_CEP=?, End_Cidade=?, End_Bairro=?, End_UF=?, End_Comp=?, DataNasc=?, foto=?, Email=? where CPF=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getRG());
            ps.setString(3, paciente.getEnd_Rua());
            ps.setString(4, paciente.getEnd_CEP());
            ps.setString(5, paciente.getEnd_Cidade());
            ps.setString(6, paciente.getEnd_Bairro());
            ps.setString(7, paciente.getEnd_UF());
            ps.setString(8, paciente.getEnd_Comp());
            ps.setString(9, paciente.getDataNasc());
            ps.setBytes(10, paciente.getFoto());
            ps.setString(11, paciente.getEmail());
            ps.setString(12, paciente.getCPF());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
    }
    public List relatorio(String CPF) {
          String sql = "select nome,cpf,rg from Paciente ORDER BY Nome";
            List lista = new ArrayList();
            try {
               PreparedStatement st = getCon().prepareStatement(sql);
               ResultSet rs = st.executeQuery();
               while (rs.next()) {
               Paciente registro = new Paciente();
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
            String sql = "select nome,cpf,rg from Paciente where nome like '%"+busca+"%'";
            List lista = new ArrayList();
            try {
                Statement st = getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Paciente registro = new Paciente();
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
    
    public Paciente localiza(String CPF) {
        String sql = "select * from Paciente where CPF=?";
        Paciente registro = new Paciente();
        try {
            PreparedStatement  ps = getCon().prepareStatement(sql);
            ps.setString(1, CPF);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                registro.setCodigo(rs.getInt("Codigo"));
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
               
                registro.setEmail(rs.getString("Email"));
                
            }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
            }
            return registro;

        }
    
}