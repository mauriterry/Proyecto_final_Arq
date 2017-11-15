/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DTOs;

import java.io.Serializable;
import java.util.Set;
/**
 *
 * @author Mauricio Rodriguez
 */
public class Producto implements Serializable {

    private int idProducto;
    private String nomproducto;
    private String tipoproducto;

    public Producto() {
        super();
    }

    public Producto(int idProducto, String nomproducto, String tipoproducto) {
        super();
        this.idProducto = idProducto;
        this.nomproducto = nomproducto;
        this.tipoproducto = tipoproducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomproducto() {
        return nomproducto;
    }

    public void setNomproducto(String nomproducto) {
        this.nomproducto = nomproducto;
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }
}
