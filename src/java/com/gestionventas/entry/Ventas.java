/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author guillermo.paez
 */
public class Ventas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    //Cabecera
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Column(name = "fecha_venta")
    private Date fechaVenta;
    @Column(name = "condicion_pago")
    private int codicionPago;
    @Column(name = "codigo_vendedor")
    private int codVendedor;

  //Detalle  
    @Column(name = "codigo_producto")
    private String codigoProducto;
    @Column(name = "precio_venta")
    private Date precioVenta;
    @Column(name = "cantidad")
    private int cantidad;

    public Ventas() {
    }
    
    

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCodicionPago() {
        return codicionPago;
    }

    public void setCodicionPago(int codicionPago) {
        this.codicionPago = codicionPago;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Date getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Date precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
