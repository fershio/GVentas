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
 * @author Guille
 */
@Entity
@Table(name = "pedido_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoDetalle.findAll", query = "SELECT p FROM PedidoDetalle p"),
    @NamedQuery(name = "PedidoDetalle.findByNumeroPedido", query = "SELECT p FROM PedidoDetalle p WHERE p.pedidoDetallePK.numeroPedido = :numeroPedido"),
    @NamedQuery(name = "PedidoDetalle.findByCodigoProducto", query = "SELECT p FROM PedidoDetalle p WHERE p.pedidoDetallePK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "PedidoDetalle.findByPrecioVenta", query = "SELECT p FROM PedidoDetalle p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "PedidoDetalle.findByCantidad", query = "SELECT p FROM PedidoDetalle p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PedidoDetalle.findByImporteGravado", query = "SELECT p FROM PedidoDetalle p WHERE p.importeGravado = :importeGravado"),
    @NamedQuery(name = "PedidoDetalle.findByImporteIva", query = "SELECT p FROM PedidoDetalle p WHERE p.importeIva = :importeIva"),
    @NamedQuery(name = "PedidoDetalle.findByImporteExento", query = "SELECT p FROM PedidoDetalle p WHERE p.importeExento = :importeExento"),
    @NamedQuery(name = "PedidoDetalle.findByImporteTotal", query = "SELECT p FROM PedidoDetalle p WHERE p.importeTotal = :importeTotal")})
public class PedidoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoDetallePK pedidoDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private BigInteger precioVenta;
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
    @Column(name = "importe_iva")
    private BigInteger importeIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_exento")
    private BigInteger importeExento;
    @Column(name = "importe_total")
    private BigInteger importeTotal;
    @JoinColumn(name = "numero_pedido", referencedColumnName = "numero_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PedidoCabecera pedidoCabecera;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public PedidoDetalle() {
    }

    public PedidoDetalle(PedidoDetallePK pedidoDetallePK) {
        this.pedidoDetallePK = pedidoDetallePK;
    }

    public PedidoDetalle(PedidoDetallePK pedidoDetallePK, BigInteger precioVenta, BigInteger cantidad, BigInteger importeGravado, BigInteger importeIva, BigInteger importeExento) {
        this.pedidoDetallePK = pedidoDetallePK;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.importeGravado = importeGravado;
        this.importeIva = importeIva;
        this.importeExento = importeExento;
    }

    public PedidoDetalle(int numeroPedido, int codigoProducto) {
        this.pedidoDetallePK = new PedidoDetallePK(numeroPedido, codigoProducto);
    }

    public PedidoDetallePK getPedidoDetallePK() {
        return pedidoDetallePK;
    }

    public void setPedidoDetallePK(PedidoDetallePK pedidoDetallePK) {
        this.pedidoDetallePK = pedidoDetallePK;
    }

    public BigInteger getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigInteger precioVenta) {
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

    public BigInteger getImporteIva() {
        return importeIva;
    }

    public void setImporteIva(BigInteger importeIva) {
        this.importeIva = importeIva;
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

    public PedidoCabecera getPedidoCabecera() {
        return pedidoCabecera;
    }

    public void setPedidoCabecera(PedidoCabecera pedidoCabecera) {
        this.pedidoCabecera = pedidoCabecera;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoDetallePK != null ? pedidoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetalle)) {
            return false;
        }
        PedidoDetalle other = (PedidoDetalle) object;
        if ((this.pedidoDetallePK == null && other.pedidoDetallePK != null) || (this.pedidoDetallePK != null && !this.pedidoDetallePK.equals(other.pedidoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.PedidoDetalle[ pedidoDetallePK=" + pedidoDetallePK + " ]";
    }
    
}
