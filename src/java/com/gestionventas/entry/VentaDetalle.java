/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guillermo.paez
 */
@Entity
@Table(name = "venta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaDetalle.findAll", query = "SELECT v FROM VentaDetalle v "),
    @NamedQuery(name = "VentaDetalle.findByNumeroFactura", query = "SELECT v FROM VentaDetalle v WHERE v.ventaDetallePK.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "VentaDetalle.findByCodigoProducto", query = "SELECT v FROM VentaDetalle v WHERE v.ventaDetallePK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "VentaDetalle.findByPrecioVenta", query = "SELECT v FROM VentaDetalle v WHERE v.precioVenta = :precioVenta"),
    @NamedQuery(name = "VentaDetalle.findByCantidad", query = "SELECT v FROM VentaDetalle v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentaDetalle.findByImporteGravado", query = "SELECT v FROM VentaDetalle v WHERE v.importeGravado = :importeGravado"),
    @NamedQuery(name = "VentaDetalle.findByImporteIva10", query = "SELECT v FROM VentaDetalle v WHERE v.importeIva10 = :importeIva10"),
    @NamedQuery(name = "VentaDetalle.findByImporteIva5", query = "SELECT v FROM VentaDetalle v WHERE v.importeIva5 = :importeIva5"),
    @NamedQuery(name = "VentaDetalle.findByImporteExento", query = "SELECT v FROM VentaDetalle v WHERE v.importeExento = :importeExento"),
    @NamedQuery(name = "VentaDetalle.findByImporteTotal", query = "SELECT v FROM VentaDetalle v WHERE v.importeTotal = :importeTotal")})
public class VentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaDetallePK ventaDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private int precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_gravado")
    private BigInteger importeGravado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_iva_10")
    private BigInteger importeIva10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_iva_5")
    private BigInteger importeIva5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_exento")
    private BigInteger importeExento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_total")
    private BigInteger importeTotal;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "numero_factura", referencedColumnName = "numero_factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private VentaCabecera ventaCabecera;
    
//    private String descripcionProducto;
    
    

    public VentaDetalle() {
    }

    public VentaDetalle(VentaDetallePK ventaDetallePK) {
        this.ventaDetallePK = ventaDetallePK;
    }

    public VentaDetalle(VentaDetallePK ventaDetallePK, int precioVenta, BigInteger cantidad, BigInteger importeGravado, BigInteger importeIva10, BigInteger importeIva5, BigInteger importeExento, BigInteger importeTotal) {
        this.ventaDetallePK = ventaDetallePK;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.importeGravado = importeGravado;
        this.importeIva10 = importeIva10;
        this.importeIva5 = importeIva5;
        this.importeExento = importeExento;
        this.importeTotal = importeTotal;
    }

    public VentaDetalle(String numeroFactura, int codigoProducto) {
        this.ventaDetallePK = new VentaDetallePK(numeroFactura, codigoProducto);
    }

    public VentaDetallePK getVentaDetallePK() {
        return ventaDetallePK;
    }

    public void setVentaDetallePK(VentaDetallePK ventaDetallePK) {
        this.ventaDetallePK = ventaDetallePK;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getImporteGravado() {
        return importeGravado;
    }

    public void setImporteGravado(BigInteger importeGravado) {
        this.importeGravado = importeGravado;
    }

    public BigInteger getImporteIva10() {
        return importeIva10;
    }

    public void setImporteIva10(BigInteger importeIva10) {
        this.importeIva10 = importeIva10;
    }

    public BigInteger getImporteIva5() {
        return importeIva5;
    }

    public void setImporteIva5(BigInteger importeIva5) {
        this.importeIva5 = importeIva5;
    }

    public BigInteger getImporteExento() {
        return importeExento;
    }

    public void setImporteExento(BigInteger importeExento) {
        this.importeExento = importeExento;
    }

    public BigInteger getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(BigInteger importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public VentaCabecera getVentaCabecera() {
        return ventaCabecera;
    }

    public void setVentaCabecera(VentaCabecera ventaCabecera) {
        this.ventaCabecera = ventaCabecera;
    }

//    public String getDescripcionProducto() {
//        return descripcionProducto;
//    }
//
//    public void setDescripcionProducto(String DescripcionProducto) {
//        this.descripcionProducto = DescripcionProducto;
//    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaDetallePK != null ? ventaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.ventaDetallePK == null && other.ventaDetallePK != null) || (this.ventaDetallePK != null && !this.ventaDetallePK.equals(other.ventaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.VentaDetalle[ ventaDetallePK=" + ventaDetallePK + " ]";
    }
    
}
