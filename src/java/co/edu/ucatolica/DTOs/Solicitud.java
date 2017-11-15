/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DTOs;

import co.edu.ucatolica.DAOs.SolicitudDAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Rodriguez
 */
public class Solicitud implements Serializable {

    private Integer idSolicitud;
    private int productoidProducto;
    private int clienteIdPersona;
    private String ingMen;
    private String ocupacion;
    private String tipoSolicitud;
    private String estado;
    private String nomC;
    private String nomP;

    public Solicitud() {
        super();
    }

    public Solicitud(Integer idSolicitud, int productoidProducto, int clienteIdPersona, String ingMen, String ocupacion, String tipoSolicitud, String estado,String nomC,String nomP) {
        super();
        this.idSolicitud = idSolicitud;
        this.productoidProducto = productoidProducto;
        this.clienteIdPersona = clienteIdPersona;
        this.ingMen = ingMen;
        this.ocupacion = ocupacion;
        this.tipoSolicitud = tipoSolicitud;
        this.estado = estado;
        this.nomC = nomC;
        this.nomP = nomP;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(int productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    public int getClienteIdPersona() {
        return clienteIdPersona;
    }

    public void setClienteIdPersona(int clienteIdPersona) {
        this.clienteIdPersona = clienteIdPersona;
    }

    public String getIngMen() {
        return ingMen;
    }

    public void setIngMen(String ingMen) {
        this.ingMen = ingMen;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrecliente() {
        return nomC;
    }

    public void setNombrecliente(String nomC) {
        this.nomC = nomC;
    }

    public String getNombreproducto() {
        return nomP;
    }

    public void setNombreproducto(String nomP) {
        this.nomP = nomP;
    }

    public ArrayList<Solicitud> aceptarSolicitud(Connection con)
    {
        
       ArrayList<Solicitud> datos = new ArrayList();
        //ArrayList datos = new ArrayList<>();
        datos.clear();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarPersona...");
       
        try {
          Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,cliente_id_persona,ing_men,ocupacion,tipoSolicitud,estado "
                    + " FROM solicitud where estado IS NULL ");
            
            while (rs.next())
            { 
                Solicitud per = new Solicitud();
                per.setIdSolicitud(rs.getInt(1));
                per.setProductoidProducto(rs.getInt(2));
                per.setClienteIdPersona(rs.getInt(3));
                per.setIngMen(rs.getString(4));
                per.setOcupacion(rs.getString(5));
                per.setTipoSolicitud(rs.getString(6));
                per.setEstado(rs.getString(7));
                datos.add(per);
                
            }
            Solicitud per=new Solicitud();
           //per.setDatos(datos);
           for (Solicitud dato : datos) {
               Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO,Integer.toString(per.getClienteIdPersona()));
           }
            
            
             Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO,String.valueOf(datos.size()));
         
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
}
