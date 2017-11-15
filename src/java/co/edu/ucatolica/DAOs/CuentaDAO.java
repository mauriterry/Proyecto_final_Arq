/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.Cuenta;
import co.edu.ucatolica.DTOs.Persona;
import co.edu.ucatolica.DTOs.Producto;
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
public class CuentaDAO {
    
    public boolean create(Cuenta ct, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.INFO, "Ejecutando crearCuenta...");
            pstmt = con.prepareStatement("INSERT INTO cuenta VALUES (?,?,?,?)");
            
            pstmt.setInt(1,ct.getIdCuenta());
            pstmt.setString(2, ct.getTipoCuenta());
            pstmt.setInt(3, ct.getClienteIdPersona());
            pstmt.setInt(4, ct.getProductoidProducto());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<Cuenta> consultarCuenta(Cuenta ct, Connection con){
        
        ArrayList<Cuenta> datos = new ArrayList<Cuenta>();
        
        Logger.getLogger(CuentaDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCuenta...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_cuenta, tipoCuenta,cliente_id_persona, Producto_id_Producto from cuenta "
                    + " where "
                    + " id_cuenta='" + ct.getIdCuenta()+"'");
            
            while (rs.next())
            { 
                Cuenta cta = new Cuenta();
                cta.setIdCuenta(rs.getInt(1));
                cta.setTipoCuenta(rs.getString(2));
                cta.setClienteIdPersona(rs.getInt(3));
                cta.setProductoidProducto(rs.getInt(4));
                datos.add(cta);
            }
            
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.INFO, "Ejecutando consultarCuenta fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(id_cuenta)+1 from cuenta");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarCuenta(Cuenta ct, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.INFO, "Ejecutando editarCuenta...");
            
            pstmt = con.prepareStatement("UPDATE cuenta "
                    + " SET "
                    + " tipoCuenta=?"
                    + " where id_cuenta=?");
                        
            pstmt.setString(1, ct.getTipoCuenta());
            pstmt.setInt(2, ct.getIdCuenta());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }
}
