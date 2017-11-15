/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DTOs;

import java.io.Serializable;
/**
 *
 * @author Mauricio Rodriguez
 */
public class EmailCliente implements Serializable {

    private Integer idcliente;
    private String emailcliente;
    private int clienteIdPersona;

    public EmailCliente() {
        super();
    }

    public EmailCliente(Integer idcliente, int clienteIdPersona) {
        super();
        this.idcliente = idcliente;
        this.clienteIdPersona = clienteIdPersona;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getEmailcliente() {
        return emailcliente;
    }

    public void setEmailcliente(String emailcliente) {
        this.emailcliente = emailcliente;
    }

    public int getClienteIdPersona() {
        return clienteIdPersona;
    }

    public void setClienteIdPersona(int clienteIdPersona) {
        this.clienteIdPersona = clienteIdPersona;
    }
}
