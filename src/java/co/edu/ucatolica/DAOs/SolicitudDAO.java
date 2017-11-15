/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DAOs;

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
public class SolicitudDAO {
    public boolean create(Solicitud emc, Connection con){
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {   
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando crearSolicitud...");
            pstmt = con.prepareStatement("INSERT INTO solicitud VALUES (?,?,?,?,?,?,?)");
            
            pstmt.setInt(1,emc.getIdSolicitud());
            pstmt.setInt(2, emc.getProductoidProducto());
            pstmt.setInt(3, emc.getClienteIdPersona());
            pstmt.setString(4, emc.getIngMen());
            pstmt.setString(5, emc.getOcupacion());
            pstmt.setString(6, emc.getTipoSolicitud());
            pstmt.setString(7, emc.getEstado());
            pstmt.execute();
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<Solicitud> consultarSolicitud(Solicitud emc, Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud...");
        
        try {
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,cliente_id_persona, ing_men, ocupacion, tipoSolicitud, estado, nombre_1, nom_producto  from solicitud,persona,producto "
                    + " where "
                    + " cliente_id_persona='" + emc.getClienteIdPersona()+"' and Producto_id_Producto=id_Producto and cliente_id_persona=id_persona;");
            
            while (rs.next())
            { 
                Solicitud sl = new Solicitud();
                sl.setIdSolicitud(rs.getInt(1));
                sl.setProductoidProducto(rs.getInt(2));
                sl.setClienteIdPersona(rs.getInt(3));
                sl.setIngMen(rs.getString(4));
                sl.setOcupacion(rs.getString(5));
                sl.setTipoSolicitud(rs.getString(6));
                sl.setEstado(rs.getString(7));
                sl.setNombrecliente(rs.getString(8));
                sl.setNombreproducto(rs.getString(9));
                datos.add(sl);
                
            }
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud fin...{0}", datos.size());
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    public ArrayList<Solicitud> consultarSolicitudprod(Solicitud emc, Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<Solicitud>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitudprod...");
        
        try {
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,cliente_id_persona, ing_men, ocupacion, tipoSolicitud, estado, nombre_1, nom_producto  from solicitud,persona,producto "
                    + " where "
                    + " Producto_id_Producto='" + emc.getProductoidProducto()+"' and Producto_id_Producto=id_Producto and cliente_id_persona=id_persona;");
            
            while (rs.next())
            { 
                Solicitud sl = new Solicitud();
                sl.setIdSolicitud(rs.getInt(1));
                sl.setProductoidProducto(rs.getInt(2));
                sl.setClienteIdPersona(rs.getInt(3));
                sl.setIngMen(rs.getString(4));
                sl.setOcupacion(rs.getString(5));
                sl.setTipoSolicitud(rs.getString(6));
                sl.setEstado(rs.getString(7));
                sl.setNombrecliente(rs.getString(8));
                sl.setNombreproducto(rs.getString(9));
                datos.add(sl);
                
            }
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitudprod fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(id_Solicitud)+1 from solicitud");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarSolicitud(Solicitud dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando editarSolicitud...");
            
            pstmt = con.prepareStatement("UPDATE solicitud "
                    + " SET "
                    + " ing_men=?"
                    + " ,ocupacion=?"
                    + " ,Producto_id_Producto=?"
                    + " ,estado=?"
                    + " where id_Solicitud=?");
                        
            pstmt.setString(1, dtc.getIngMen());
            pstmt.setString(2, dtc.getOcupacion());
            pstmt.setString(3, String.valueOf(dtc.getProductoidProducto()));
            pstmt.setString(4, dtc.getEstado());
            pstmt.setInt(5, dtc.getIdSolicitud());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    

    public ArrayList<Solicitud> consultarAceptada(Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<Solicitud>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,cliente_id_persona, ing_men, ocupacion, tipoSolicitud, estado, nombre_1, nom_producto  from solicitud,persona,producto"
                    + " where "
                    + " estado='aceptado' and Producto_id_Producto=id_Producto and cliente_id_persona=id_persona");
            
            while (rs.next())
            { 
                Solicitud cta = new Solicitud();
                cta.setIdSolicitud(rs.getInt(1));
                cta.setProductoidProducto(rs.getInt(2));
                cta.setClienteIdPersona(rs.getInt(3));
                cta.setIngMen(rs.getString(4));
                cta.setOcupacion(rs.getString(5));
                cta.setTipoSolicitud(rs.getString(6));
                cta.setEstado(rs.getString(7));
                cta.setNombrecliente(rs.getString(8));
                cta.setNombreproducto(rs.getString(9));
                datos.add(cta);
            }
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    public ArrayList<Solicitud> consultarRechazada(Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<Solicitud>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,cliente_id_persona, ing_men, ocupacion, tipoSolicitud, estado, nombre_1, nom_producto  from solicitud,persona,producto"
                    + " where "
                    + " estado='rechazado' and Producto_id_Producto=id_Producto and cliente_id_persona=id_persona");
            
            while (rs.next())
            { 
                Solicitud cta = new Solicitud();
                cta.setIdSolicitud(rs.getInt(1));
                cta.setProductoidProducto(rs.getInt(2));
                cta.setClienteIdPersona(rs.getInt(3));
                cta.setIngMen(rs.getString(4));
                cta.setOcupacion(rs.getString(5));
                cta.setTipoSolicitud(rs.getString(6));
                cta.setEstado(rs.getString(7));
                cta.setNombrecliente(rs.getString(8));
                cta.setNombreproducto(rs.getString(9));
                datos.add(cta);
            }
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
        public ArrayList<Solicitud> consultarPendiente(Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<Solicitud>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,identificacion, ing_men, ocupacion, tipoSolicitud, estado, nombre_1, nom_producto  from solicitud,persona,producto"
                    + " where "
                    + " estado='pendiente' and Producto_id_Producto=id_Producto and cliente_id_persona=id_persona");
            
            while (rs.next())
            { 
                Solicitud cta = new Solicitud();
                cta.setIdSolicitud(rs.getInt(1));
                cta.setProductoidProducto(rs.getInt(2));
                cta.setClienteIdPersona(rs.getInt(3));
                cta.setIngMen(rs.getString(4));
                cta.setOcupacion(rs.getString(5));
                cta.setTipoSolicitud(rs.getString(6));
                cta.setEstado(rs.getString(7));
                cta.setNombrecliente(rs.getString(8));
                cta.setNombreproducto(rs.getString(9));
                datos.add(cta);
            }
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    public int obtenerIdS(String tipo,String iden,Connection con){
        int id=0;
        try {
            Statement s = con.createStatement();
             ResultSet rs = s.executeQuery ("select idSolicitud from solicitud where identificacion='"+iden+"'and tipoSolicitud='"+tipo+"' ");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }
           

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
        public ArrayList<Solicitud> consultarSolicitudCliente(Solicitud emc, Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<Solicitud>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,cliente_id_persona, ing_men, ocupacion, tipoSolicitud, estado  from solicitud "
                    + " where "
                    + " cliente_id_persona='" + emc.getIdSolicitud()+"'");
            
            while (rs.next())
            { 
                Solicitud sl = new Solicitud();
                sl.setIdSolicitud(rs.getInt(1));
                sl.setProductoidProducto(rs.getInt(2));
                sl.setClienteIdPersona(rs.getInt(3));
                sl.setIngMen(rs.getString(4));
                sl.setOcupacion(rs.getString(5));
                sl.setTipoSolicitud(rs.getString(6));
                sl.setEstado(rs.getString(7));
                datos.add(sl);
            }
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }

    public String obtenerTipo(String productoidProducto, Connection con) {
        String tipoProducto="";
        try {
            Statement s = con.createStatement();
             ResultSet rs = s.executeQuery ("select Tipo_producto from producto where id_Producto='"+productoidProducto+"';");
            
            while (rs.next())
            { 
                tipoProducto = rs.getString(1);
            }
           

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoProducto;
    }

    public int obtenerIdS(int idclient, Connection con) {
        int id=0;
        try {
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery ("select id_Solicitud from solicitud where cliente_id_persona='"+idclient+"';");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }
           

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
     public int obtenerIdS2(int idclient,int idprod, Connection con) {
        int id=0;
        try {
             Statement s = con.createStatement();
             ResultSet rs = s.executeQuery ("select id_Solicitud from solicitud where cliente_id_persona='"+idclient+"' and Producto_id_Producto='"+idprod+"';");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }
           

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    public ArrayList<Solicitud> consultarSolicitud1(Solicitud emc, Connection con){
        
        ArrayList<Solicitud> datos = new ArrayList<>();
        
        Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud1...");
        
        try {
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select id_Solicitud, Producto_id_Producto,identificacion, ing_men, ocupacion, tipoSolicitud, estado, nombre_1, nom_producto  from solicitud,persona,producto "
                    + " where "
                    + " cliente_id_persona='" + emc.getClienteIdPersona()+"' and Producto_id_Producto=" + emc.getProductoidProducto()+" and Producto_id_Producto=id_Producto and cliente_id_persona=id_persona;");
            
            while (rs.next())
            { 
                Solicitud sl = new Solicitud();
                sl.setIdSolicitud(rs.getInt(1));
                sl.setProductoidProducto(rs.getInt(2));
                sl.setClienteIdPersona(rs.getInt(3));
                sl.setIngMen(rs.getString(4));
                sl.setOcupacion(rs.getString(5));
                sl.setTipoSolicitud(rs.getString(6));
                sl.setEstado(rs.getString(7));
                sl.setNombrecliente(rs.getString(8));
                sl.setNombreproducto(rs.getString(9));
                datos.add(sl);
                
            }
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando consultarSolicitud fin...{0}", datos.size());
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    public boolean editarEstado(Solicitud dtc, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.INFO, "Ejecutando editarSolicitud...");
            
            pstmt = con.prepareStatement("UPDATE solicitud "
                    + " SET "
                    + " estado=?"
                    + " where id_Solicitud=?");
                        
            pstmt.setString(1, dtc.getEstado());
            pstmt.setInt(2, dtc.getIdSolicitud());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }    
}
