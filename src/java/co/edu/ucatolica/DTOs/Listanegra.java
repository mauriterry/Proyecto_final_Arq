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
public class Listanegra implements Serializable {

    private Integer idLista;
    private int clienteIdPersona;
    private String descripcion;

    public Listanegra() {
        super();
    }

    public Listanegra(Integer idLista, int clienteIdPersona, String descripcion) {
        super();
        this.idLista = idLista;
        this.clienteIdPersona = clienteIdPersona;
        this.descripcion = descripcion;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public int getClienteIdPersona() {
        return clienteIdPersona;
    }

    public void setClienteIdPersona(int clienteIdPersona) {
        this.clienteIdPersona = clienteIdPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
