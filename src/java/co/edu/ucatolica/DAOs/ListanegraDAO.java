/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.Listanegra;
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
public class ListanegraDAO {
    public boolean create(Listanegra lsn, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.INFO, "Ejecutando crearListanegra...");
            pstmt = con.prepareStatement("INSERT INTO email_cliente VALUES (?,?,?)");
            
            pstmt.setInt(1,lsn.getIdLista());
            pstmt.setInt(2, lsn.getClienteIdPersona());
            pstmt.setString(3, lsn.getDescripcion());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(ListanegraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<Listanegra> consultarListanegra(Listanegra lsn, Connection con){
        
        ArrayList<Listanegra> datos = new ArrayList<Listanegra>();
        
        Logger.getLogger(ListanegraDAO.class.getName()).log(Level.INFO, "Ejecutando consultarListanegra...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select idLista,clienteIdPersona,descripcion from listanegra "
                    + " where "
                    + " idLista='" + lsn.getIdLista()+"'");
            
            while (rs.next())
            { 
                Listanegra cta = new Listanegra();
                cta.setIdLista(rs.getInt(1));
                cta.setClienteIdPersona(rs.getInt(2));
                cta.setDescripcion(rs.getString(3));
                datos.add(cta);
            }
            
            Logger.getLogger(ListanegraDAO.class.getName()).log(Level.INFO, "Ejecutando consultarListanegra fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ListanegraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(idLista)+1 from listanegra");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ListanegraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarListanegra(Listanegra dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(ListanegraDAO.class.getName()).log(Level.INFO, "Ejecutando editarListanegra...");
            
            pstmt = con.prepareStatement("UPDATE listanegra "
                    + " SET "
                    + " descripcion=?"
                    + " where idLista=?");
                        
            pstmt.setString(1, dtc.getDescripcion());
            pstmt.setInt(2, dtc.getIdLista());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(ListanegraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    
}
