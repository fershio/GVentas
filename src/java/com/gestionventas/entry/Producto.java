/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodigoProducto", query = "SELECT p FROM Producto p WHERE p.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Producto.findByDescripcionProducto", query = "SELECT p FROM Producto p WHERE p.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "Producto.findByCostoProducto", query = "SELECT p FROM Producto p WHERE p.costoProducto = :costoProducto"),
    @NamedQuery(name = "Producto.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Producto.findByStockMinimo", query = "SELECT p FROM Producto p WHERE p.stockMinimo = :stockMinimo"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
    @NamedQuery(name = "Producto.findByTipoImpuesto", query = "SELECT p FROM Producto p WHERE p.tipoImpuesto = :tipoImpuesto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private Integer codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Column(name = "costo_producto")
    private BigInteger costoProducto;
    @Column(name = "precio_venta")
    private BigInteger precioVenta;
    @Column(name = "stock_minimo")
    private BigInteger stockMinimo;
    @Size(max = 2147483647)
    @Column(name = "stock")
    private Integer stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_impuesto")
    private short tipoImpuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<PresupuestoDetalle> presupuestoDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<VentaDetalle> ventaDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<PedidoDetalle> pedidoDetalleList;

    public Producto() {
    }

    public Producto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Producto(Integer codigoProducto, String descripcionProducto, short tipoImpuesto) {
        this.codigoProducto = codigoProducto;
        this.descripcionProducto = descripcionProducto;
        this.tipoImpuesto = tipoImpuesto;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public BigInteger getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(BigInteger costoProducto) {
        this.costoProducto = costoProducto;
    }

    public BigInteger getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigInteger precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigInteger getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(BigInteger stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public short getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(short tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    @XmlTransient
    public List<PresupuestoDetalle> getPresupuestoDetalleList() {
        return presupuestoDetalleList;
    }

    public void setPresupuestoDetalleList(List<PresupuestoDetalle> presupuestoDetalleList) {
        this.presupuestoDetalleList = presupuestoDetalleList;
    }

    @XmlTransient
    public List<VentaDetalle> getVentaDetalleList() {
        return ventaDetalleList;
    }

    public void setVentaDetalleList(List<VentaDetalle> ventaDetalleList) {
        this.ventaDetalleList = ventaDetalleList;
    }

    @XmlTransient
    public List<PedidoDetalle> getPedidoDetalleList() {
        return pedidoDetalleList;
    }

    public void setPedidoDetalleList(List<PedidoDetalle> pedidoDetalleList) {
        this.pedidoDetalleList = pedidoDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.Producto[ codigoProducto=" + codigoProducto + " ]";
    }
    
}
