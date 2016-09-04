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
@Table(name = "presupuesto_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoDetalle.findAll", query = "SELECT p FROM PresupuestoDetalle p"),
    @NamedQuery(name = "PresupuestoDetalle.findByPresupuestoNumero", query = "SELECT p FROM PresupuestoDetalle p WHERE p.presupuestoDetallePK.presupuestoNumero = :presupuestoNumero"),
    @NamedQuery(name = "PresupuestoDetalle.findByCodigoProducto", query = "SELECT p FROM PresupuestoDetalle p WHERE p.presupuestoDetallePK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "PresupuestoDetalle.findByCantidad", query = "SELECT p FROM PresupuestoDetalle p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PresupuestoDetalle.findByPrecioPresupuesto", query = "SELECT p FROM PresupuestoDetalle p WHERE p.precioPresupuesto = :precioPresupuesto"),
    @NamedQuery(name = "PresupuestoDetalle.findByTotal", query = "SELECT p FROM PresupuestoDetalle p WHERE p.total = :total")})
public class PresupuestoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PresupuestoDetallePK presupuestoDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_presupuesto")
    private BigInteger precioPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigInteger total;
    @JoinColumn(name = "presupuesto_numero", referencedColumnName = "numero_presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PresupuestoCabecera presupuestoCabecera;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public PresupuestoDetalle() {
    }

    public PresupuestoDetalle(PresupuestoDetallePK presupuestoDetallePK) {
        this.presupuestoDetallePK = presupuestoDetallePK;
    }

    public PresupuestoDetalle(PresupuestoDetallePK presupuestoDetallePK, BigInteger cantidad, BigInteger precioPresupuesto, BigInteger total) {
        this.presupuestoDetallePK = presupuestoDetallePK;
        this.cantidad = cantidad;
        this.precioPresupuesto = precioPresupuesto;
        this.total = total;
    }

    public PresupuestoDetalle(int presupuestoNumero, int codigoProducto) {
        this.presupuestoDetallePK = new PresupuestoDetallePK(presupuestoNumero, codigoProducto);
    }

    public PresupuestoDetallePK getPresupuestoDetallePK() {
        return presupuestoDetallePK;
    }

    public void setPresupuestoDetallePK(PresupuestoDetallePK presupuestoDetallePK) {
        this.presupuestoDetallePK = presupuestoDetallePK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPrecioPresupuesto() {
        return precioPresupuesto;
    }

    public void setPrecioPresupuesto(BigInteger precioPresupuesto) {
        this.precioPresupuesto = precioPresupuesto;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public PresupuestoCabecera getPresupuestoCabecera() {
        return presupuestoCabecera;
    }

    public void setPresupuestoCabecera(PresupuestoCabecera presupuestoCabecera) {
        this.presupuestoCabecera = presupuestoCabecera;
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
        hash += (presupuestoDetallePK != null ? presupuestoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoDetalle)) {
            return false;
        }
        PresupuestoDetalle other = (PresupuestoDetalle) object;
        if ((this.presupuestoDetallePK == null && other.presupuestoDetallePK != null) || (this.presupuestoDetallePK != null && !this.presupuestoDetallePK.equals(other.presupuestoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.PresupuestoDetalle[ presupuestoDetallePK=" + presupuestoDetallePK + " ]";
    }
    
}
