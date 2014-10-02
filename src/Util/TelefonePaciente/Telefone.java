/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util.TelefonePaciente;

/**
 *
 * @author Robsonzinho
 */
public class Telefone {
    private String CPF_Paciente;
    private String Telefone;
    private String Tipo;

    /**
     * @return the CPF_Paciente
     */
    public String getCPF_Paciente() {
        return CPF_Paciente;
    }

    /**
     * @param CPF_Paciente the CPF_Paciente to set
     */
    public void setCPF_Paciente(String CPF_Paciente) {
        this.CPF_Paciente = CPF_Paciente;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
