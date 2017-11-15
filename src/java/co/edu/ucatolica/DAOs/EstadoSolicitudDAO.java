/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.EstadoSolicitud;
import co.edu.ucatolica.DTOs.Solicitud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Rodriguez
 */
public class EstadoSolicitudDAO {
    public boolean create(EstadoSolicitud ess, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando crearEstadoSolicitud...");
            pstmt = con.prepareStatement("INSERT INTO email_cliente VALUES (?,?,?)");
            
            pstmt.setInt(1,ess.getIdestado());
            pstmt.setString(2, ess.getEstado());
            pstmt.setInt(3, ess.getSolicitudIdSolicitud());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<EstadoSolicitud> consultarEstadoSolicitud(EstadoSolicitud ess, Connection con){
        
        ArrayList<EstadoSolicitud> datos = new ArrayList<EstadoSolicitud>();
        
        Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstadoSolicitud...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select idestado, estado,solicitudIdSolicitud from estado_solicitud "
                    + " where "
                    + " idestado='" + ess.getIdestado()+"'");
            
            while (rs.next())
            { 
                EstadoSolicitud cta = new EstadoSolicitud();
                cta.setIdestado(rs.getInt(1));
                cta.setEstado(rs.getString(2));
                cta.setSolicitudIdSolicitud(rs.getInt(3));
                datos.add(cta);
            }
            
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstadoSolicitud fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(idestado)+1 from estado_solicitud");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarEstadoSolicitud(EstadoSolicitud ess, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando editarEstadoSolicitud...");
            
            pstmt = con.prepareStatement("UPDATE estado_solicitud "
                    + " SET "
                    + " estado=?"
                    + " where idestado=?");
                        
            pstmt.setString(1, ess.getEstado());
            pstmt.setInt(2, ess.getIdestado());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoSolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    
}
