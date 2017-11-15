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
public class Datacredito implements Serializable {

    private Integer iddataCredito;
    private String clasificacion;
    private int clienteIdPersona;
    private String novedad;

    public Datacredito() {
        super();
    }

    public Datacredito(Integer iddataCredito, String clasificacion, int clienteIdPersona, String novedad) {
        super();
        this.iddataCredito = iddataCredito;
        this.clasificacion = clasificacion;
        this.clienteIdPersona = clienteIdPersona;
        this.novedad = novedad;
    }

    public Integer getIddataCredito() {
        return iddataCredito;
    }

    public void setIddataCredito(Integer iddataCredito) {
        this.iddataCredito = iddataCredito;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getClienteIdPersona() {
        return clienteIdPersona;
    }

    public void setClienteIdPersona(int clienteIdPersona) {
        this.clienteIdPersona = clienteIdPersona;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
}
