/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.EmailCliente;
import co.edu.ucatolica.DTOs.RespuestaEmail;
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
public class RespuestaEmailDAO {
    public boolean create(RespuestaEmail emc, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.INFO, "Ejecutando crearRespuestaEmail...");
            pstmt = con.prepareStatement("INSERT INTO email_cliente VALUES (?,?,?,?)");
            
            pstmt.setInt(1,emc.getEmailcliente());
            pstmt.setString(2, emc.getPlantillaRechazo());
            pstmt.setString(3, emc.getPlantillaAprobo());
            pstmt.setInt(4, emc.getEmailclienteIdcliente());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<RespuestaEmail> consultarRespuestaEmail(RespuestaEmail emc, Connection con){
        
        ArrayList<RespuestaEmail> datos = new ArrayList<RespuestaEmail>();
        
        Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.INFO, "Ejecutando consultarRespuestaEmail...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select emailcliente, plantillaRechazo,plantillaaprob�, emailclienteIdcliente from respuesta_email "
                    + " where "
                    + " emailcliente='" + emc.getEmailcliente()+"'");
            
            while (rs.next())
            { 
                RespuestaEmail cta = new RespuestaEmail();
                cta.setEmailcliente(rs.getInt(1));
                cta.setPlantillaRechazo(rs.getString(2));
                cta.setPlantillaaprobo(rs.getString(3));
                cta.setEmailclienteIdcliente(rs.getInt(4));
                datos.add(cta);
            }
            
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.INFO, "Ejecutando consultarRespuestaEmail fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(emailcliente)+1 from respuesta_email");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarRespuestaEmail(RespuestaEmail dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.INFO, "Ejecutando editarRespuestaEmail...");
            
            pstmt = con.prepareStatement("UPDATE respuesta_email "
                    + " SET "
                    + " plantillaRechazo=?"
                    + " ,plantillaaprob�=?"
                    + " where emailcliente=?");
                        
            pstmt.setString(1, dtc.getPlantillaRechazo());
            pstmt.setString(2, dtc.getPlantillaAprobo());
            pstmt.setInt(3, dtc.getEmailcliente());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(RespuestaEmailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    
}
