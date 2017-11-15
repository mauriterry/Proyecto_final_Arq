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
public class RespuestaEmail implements Serializable {

    private Integer emailcliente;
    private String plantillaRechazo;
    private String plantillaaprobo;
    private int emailclienteIdcliente;

    public RespuestaEmail() {
        super();
    }

    public RespuestaEmail(Integer emailcliente, int emailclienteIdcliente) {
        super();
        this.emailcliente = emailcliente;
        this.emailclienteIdcliente = emailclienteIdcliente;
    }

    public Integer getEmailcliente() {
        return emailcliente;
    }

    public void setEmailcliente(Integer emailcliente) {
        this.emailcliente = emailcliente;
    }

    public String getPlantillaRechazo() {
        return plantillaRechazo;
    }

    public void setPlantillaRechazo(String plantillaRechazo) {
        this.plantillaRechazo = plantillaRechazo;
    }

    public String getPlantillaAprobo() {
        return plantillaaprobo;
    }

    public void setPlantillaaprobo(String plantillaaprobo) {
        this.plantillaaprobo = plantillaaprobo;
    }

    public int getEmailclienteIdcliente() {
        return emailclienteIdcliente;
    }

    public void setEmailclienteIdcliente(int emailclienteIdcliente) {
        this.emailclienteIdcliente = emailclienteIdcliente;
    }   
}
