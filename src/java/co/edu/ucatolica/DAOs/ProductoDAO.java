/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

import co.edu.ucatolica.DTOs.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ProductoDAO {
    public boolean create(Producto prt, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.INFO, "Ejecutando crearProducto...");
            pstmt = con.prepareStatement("INSERT INTO producto VALUES (?,?,?)");
            pstmt.setInt(1,prt.getIdProducto());
            pstmt.setString(2, prt.getNomproducto());
            pstmt.setString(3, prt.getTipoproducto());
            pstmt.execute();
            con.close();
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    public ArrayList<Producto> consultarProducto(Producto emc, Connection con){
        
        ArrayList<Producto> datos = new ArrayList<Producto>();
        
        Logger.getLogger(EmailClienteDAO.class.getName()).log(Level.INFO, "Ejecutando consultarProducto...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select idProducto, nomproducto,tipoproducto from producto "
                    + " where "
                    + " idProducto='" + emc.getIdProducto()+"'");
            
            while (rs.next())
            { 
                Producto cta = new Producto();
                cta.setIdProducto(rs.getInt(1));
                cta.setNomproducto(rs.getString(2));
                cta.setTipoproducto(rs.getString(3));
                datos.add(cta);
            }
            
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.INFO, "Ejecutando consultarProducto fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(idProducto)+1 from producto");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarProducto(Producto dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.INFO, "Ejecutando editarProducto...");
            pstmt = con.prepareStatement("UPDATE producto "
                    + " SET "
                    + " nomproducto=?"
                    + " ,tipoproducto=?"
                    + " where idProducto=?");
                        
            pstmt.setString(1, dtc.getNomproducto());
            pstmt.setString(2, dtc.getTipoproducto());
            pstmt.setInt(2, dtc.getIdProducto());
            pstmt.executeUpdate();
            con.close();
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }

    public int obtenerTipoProducto(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(idProducto)+1 from producto");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public List<Producto> Listarprocedencia(Producto Producto,Connection con) {
        PreparedStatement instruccion=null;
        ResultSet resultado=null;
        List<Producto> producto = new ArrayList<>();

        try{
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select Tipo_producto from producto;");
            
            while (rs.next()) {
                Producto = new Producto();
                Producto.setTipoproducto(resultado.getString(1));
                producto.add(Producto);
            }
        } catch (SQLException e) {
        } finally{
            try {
               if (resultado != null) resultado.close();
               if (instruccion != null) instruccion.close();
            } catch (SQLException ex) {
            }
        }

        return producto;
    }
    
}
