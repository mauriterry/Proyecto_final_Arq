/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.Datacredito;
import co.edu.ucatolica.DTOs.Persona;
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
public class DatacreditoDAO {
    
     public boolean create(Datacredito dtc, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.INFO, "Ejecutando crearCuenta...");
            pstmt = con.prepareStatement("INSERT INTO cuenta VALUES (?,?,?,?)");
            
            pstmt.setInt(1,dtc.getIddataCredito());
            pstmt.setString(2, dtc.getClasificacion());
            pstmt.setInt(3, dtc.getClienteIdPersona());
            pstmt.setString(4, dtc.getNovedad());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<Datacredito> consultarDatacredito(Datacredito dtc, Connection con){
        
        ArrayList<Datacredito> datos = new ArrayList<Datacredito>();
        
        Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.INFO, "Ejecutando consultarDatacredito...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select iddataCredito, clasificacion,clienteIdPersona, novedad from datacredito "
                    + " where "
                    + " iddataCredito='" + dtc.getIddataCredito()+"'");
            
            while (rs.next())
            { 
                Datacredito cta = new Datacredito();
                cta.setIddataCredito(rs.getInt(1));
                cta.setClasificacion(rs.getString(2));
                cta.setClienteIdPersona(rs.getInt(3));
                cta.setNovedad(rs.getString(4));
                datos.add(cta);
            }
            
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.INFO, "Ejecutando consultarDatacredito fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(iddataCredito)+1 from datacredito");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarDatacredito(Datacredito dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.INFO, "Ejecutando editarDatacredito...");
            
            pstmt = con.prepareStatement("UPDATE datacredito "
                    + " SET "
                    + " clasificacion=?,"
                    + " novedad=?"
                    + " where iddataCredito=?");
                        
            pstmt.setString(1, dtc.getClasificacion());
            pstmt.setString(2, dtc.getNovedad());
            pstmt.setInt(3, dtc.getIddataCredito());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(DatacreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    
}
