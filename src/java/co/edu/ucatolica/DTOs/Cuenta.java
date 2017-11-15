/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.DTOs;

import java.io.Serializable;

/**
 *
 * @author Mauricio Rodriguez
 */
public class Cuenta implements Serializable {

    private Integer idCuenta;
    private String tipoCuenta;
    private int clienteIdPersona;
    private int productoidProducto;

    public Cuenta() {
        super();
    }

    public Cuenta(Integer idCuenta, String tipoCuenta, int clienteIdPersona, int productoidProducto) {
        super();
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
        this.clienteIdPersona = clienteIdPersona;
        this.productoidProducto = productoidProducto;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getClienteIdPersona() {
        return clienteIdPersona;
    }

    public void setClienteIdPersona(int clienteIdPersona) {
        this.clienteIdPersona = clienteIdPersona;
    }

    public int getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(int productoidProducto) {
        this.productoidProducto = productoidProducto;
    } 
}
