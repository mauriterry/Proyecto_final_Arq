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
public class EstadoSolicitud implements Serializable {

    private Integer idestado;
    private String estado;
    private int solicitudIdSolicitud;

    public EstadoSolicitud() {
        super();
    }

    public EstadoSolicitud(Integer idestado, String estado) {
        super();
        this.idestado = idestado;
        this.estado = estado;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getSolicitudIdSolicitud() {
        return solicitudIdSolicitud;
    }

    public void setSolicitudIdSolicitud(int solicitudIdSolicitud) {
        this.solicitudIdSolicitud = solicitudIdSolicitud;
    }    
}
