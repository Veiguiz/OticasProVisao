/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Daniel
 */
import java.sql.*;
public class Bd {
   private Connection con;
   private String driver;
   private String url;
   private String usuario;
   private String senha;
   private String erro;
   public Bd(){
       this.setDriver("com.mysql.jdbc.Driver");
       this.setUrl("jdbc:mysql://barekode.com.br:3306/barekode_ProVisao");
       this.setUsuario("barekode_provisa");
       this.setSenha("Brasil2014");
       this.setErro("");
       this.setCon(null);
   }
   public void conexao() throws Exception{
       try{
           Class.forName(this.getDriver());
           this.setCon(DriverManager.getConnection(this.getUrl(), this.getUsuario(), this.getSenha()));
       } catch(Exception e){
           this.setErro("Erro na conexao\n" + e.getMessage());
           throw e;

       }
   }

   public void fecha(){
       try {
            getCon().close();
       } catch (SQLException e) {
           this.setErro("Erro ao fechar Conexão\n"+e.getMessage());
       }
   }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }
}
