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
@Table(name = "pedido_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoCabecera.findAll", query = "SELECT p FROM PedidoCabecera p"),
    @NamedQuery(name = "PedidoCabecera.findByNumeroPedido", query = "SELECT p FROM PedidoCabecera p WHERE p.numeroPedido = :numeroPedido"),
    @NamedQuery(name = "PedidoCabecera.findByFechaPedido", query = "SELECT p FROM PedidoCabecera p WHERE p.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "PedidoCabecera.findByCodigoVendedor", query = "SELECT p FROM PedidoCabecera p WHERE p.codigoVendedor = :codigoVendedor"),
    @NamedQuery(name = "PedidoCabecera.findByImporteGravado", query = "SELECT p FROM PedidoCabecera p WHERE p.importeGravado = :importeGravado"),
    @NamedQuery(name = "PedidoCabecera.findByImporteIva", query = "SELECT p FROM PedidoCabecera p WHERE p.importeIva = :importeIva"),
    @NamedQuery(name = "PedidoCabecera.findByImporteExento", query = "SELECT p FROM PedidoCabecera p WHERE p.importeExento = :importeExento"),
    @NamedQuery(name = "PedidoCabecera.findByImporteTotal", query = "SELECT p FROM PedidoCabecera p WHERE p.importeTotal = :importeTotal")})
public class PedidoCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_pedido")
    private Integer numeroPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_vendedor")
    private int codigoVendedor;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_total")
    private BigInteger importeTotal;
    @OneToMany(mappedBy = "numeroPedido")
    private List<VentaCabecera> ventaCabeceraList;
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente")
    @ManyToOne(optional = false)
    private Cliente codigoCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCabecera")
    private List<PedidoDetalle> pedidoDetalleList;

    public PedidoCabecera() {
    }

    public PedidoCabecera(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public PedidoCabecera(Integer numeroPedido, Date fechaPedido, int codigoVendedor, BigInteger importeGravado, BigInteger importeIva, BigInteger importeExento, BigInteger importeTotal) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.codigoVendedor = codigoVendedor;
        this.importeGravado = importeGravado;
        this.importeIva = importeIva;
        this.importeExento = importeExento;
        this.importeTotal = importeTotal;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
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

    @XmlTransient
    public List<VentaCabecera> getVentaCabeceraList() {
        return ventaCabeceraList;
    }

    public void setVentaCabeceraList(List<VentaCabecera> ventaCabeceraList) {
        this.ventaCabeceraList = ventaCabeceraList;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
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
        hash += (numeroPedido != null ? numeroPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoCabecera)) {
            return false;
        }
        PedidoCabecera other = (PedidoCabecera) object;
        if ((this.numeroPedido == null && other.numeroPedido != null) || (this.numeroPedido != null && !this.numeroPedido.equals(other.numeroPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.PedidoCabecera[ numeroPedido=" + numeroPedido + " ]";
    }
    
}
