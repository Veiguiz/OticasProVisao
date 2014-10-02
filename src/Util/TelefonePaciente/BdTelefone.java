/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util.TelefonePaciente;

/**
 *
 * @author Daniel
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BdTelefone extends bd.Bd {

    public BdTelefone() {
        try{
            conexao();
    }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Conexão!\n" +e.getMessage());
        }
    }
    
    public void insere(Telefone tel){
        String sql = "insert into Telefone (CPF_Paciente,Telefone,Tipo)values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, tel.getCPF_Paciente());
            ps.setString(2, tel.getTelefone());
            ps.setString(3, tel.getTipo());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Telefone!\n" +e.getMessage());
        }
    }
    
    public void exclui(String Telefone){
        String sql="delete from Telefone where Telefone=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, Telefone);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Telefone!\n" +e.getMessage());
        }
    }
    
    public ArrayList pesquisa(String cpf){
        String sql = "select * from Telefone where CPF_Paciente='"+cpf+"'";
        ArrayList lista = new ArrayList();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Telefone tel  = new Telefone();
                tel.setCPF_Paciente(rs.getString("CPF_Paciente"));
                tel.setTelefone(rs.getString("Telefone"));
                tel.setTipo(rs.getString("Tipo"));
                lista.add(tel);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar Telefone!\n" +e.getMessage());
        }
        return lista;
    }
    
    
    
    
    
}
