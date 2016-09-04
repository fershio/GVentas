/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "presupuesto_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoCabecera.findAll", query = "SELECT p FROM PresupuestoCabecera p"),
    @NamedQuery(name = "PresupuestoCabecera.findByNumeroPresupuesto", query = "SELECT p FROM PresupuestoCabecera p WHERE p.numeroPresupuesto = :numeroPresupuesto"),
    @NamedQuery(name = "PresupuestoCabecera.findByFechaPresupuesto", query = "SELECT p FROM PresupuestoCabecera p WHERE p.fechaPresupuesto = :fechaPresupuesto"),
    @NamedQuery(name = "PresupuestoCabecera.findByTotalPresupuesto", query = "SELECT p FROM PresupuestoCabecera p WHERE p.totalPresupuesto = :totalPresupuesto")})
public class PresupuestoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_presupuesto")
    private Integer numeroPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_presupuesto")
    @Temporal(TemporalType.DATE)
    private Date fechaPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_presupuesto")
    private BigInteger totalPresupuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuestoCabecera")
    private List<PresupuestoDetalle> presupuestoDetalleList;
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente")
    @ManyToOne(optional = false)
    private Cliente codigoCliente;

    public PresupuestoCabecera() {
    }

    public PresupuestoCabecera(Integer numeroPresupuesto) {
        this.numeroPresupuesto = numeroPresupuesto;
    }

    public PresupuestoCabecera(Integer numeroPresupuesto, Date fechaPresupuesto, BigInteger totalPresupuesto) {
        this.numeroPresupuesto = numeroPresupuesto;
        this.fechaPresupuesto = fechaPresupuesto;
        this.totalPresupuesto = totalPresupuesto;
    }

    public Integer getNumeroPresupuesto() {
        return numeroPresupuesto;
    }

    public void setNumeroPresupuesto(Integer numeroPresupuesto) {
        this.numeroPresupuesto = numeroPresupuesto;
    }

    public Date getFechaPresupuesto() {
        return fechaPresupuesto;
    }

    public void setFechaPresupuesto(Date fechaPresupuesto) {
        this.fechaPresupuesto = fechaPresupuesto;
    }

    public BigInteger getTotalPresupuesto() {
        return totalPresupuesto;
    }

    public void setTotalPresupuesto(BigInteger totalPresupuesto) {
        this.totalPresupuesto = totalPresupuesto;
    }

    @XmlTransient
    public List<PresupuestoDetalle> getPresupuestoDetalleList() {
        return presupuestoDetalleList;
    }

    public void setPresupuestoDetalleList(List<PresupuestoDetalle> presupuestoDetalleList) {
        this.presupuestoDetalleList = presupuestoDetalleList;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPresupuesto != null ? numeroPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoCabecera)) {
            return false;
        }
        PresupuestoCabecera other = (PresupuestoCabecera) object;
        if ((this.numeroPresupuesto == null && other.numeroPresupuesto != null) || (this.numeroPresupuesto != null && !this.numeroPresupuesto.equals(other.numeroPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.PresupuestoCabecera[ numeroPresupuesto=" + numeroPresupuesto + " ]";
    }
    
}
