/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.EmailCliente;
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
public class EmailClienteDAO {
    public boolean create(EmailCliente emc, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.INFO, "Ejecutando crearEmailCliente...");
            pstmt = con.prepareStatement("INSERT INTO email_cliente VALUES (?,?,?)");
            
            pstmt.setInt(1,emc.getIdcliente());
            pstmt.setString(2, emc.getEmailcliente());
            pstmt.setInt(3, emc.getClienteIdPersona());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<EmailCliente> consultarEmailCliente(EmailCliente emc, Connection con){
        
        ArrayList<EmailCliente> datos = new ArrayList<EmailCliente>();
        
        Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEmailCliente...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select idcliente, emailcliente,clienteIdPersona from email_cliente "
                    + " where "
                    + " idcliente='" + emc.getIdcliente()+"'");
            
            while (rs.next())
            { 
                EmailCliente cta = new EmailCliente();
                cta.setIdcliente(rs.getInt(1));
                cta.setEmailcliente(rs.getString(2));
                cta.setClienteIdPersona(rs.getInt(3));
                datos.add(cta);
            }
            
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEmailCliente fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(idcliente)+1 from email_cliente");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarEmailCliente(EmailCliente dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.INFO, "Ejecutando editarEmailCliente...");
            
            pstmt = con.prepareStatement("UPDATE email_cliente "
                    + " SET "
                    + " emailcliente=?"
                    + " where idcliente=?");
                        
            pstmt.setString(1, dtc.getEmailcliente());
            pstmt.setInt(2, dtc.getIdcliente());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    
}
