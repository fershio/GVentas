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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guillermo.paez
 */
@Entity
@Table(name = "venta_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaCabecera.findAll", query = "SELECT v FROM VentaCabecera v"),
    @NamedQuery(name = "VentaCabecera.findByNumeroFactura", query = "SELECT v FROM VentaCabecera v WHERE v.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "VentaCabecera.findByFechaVenta", query = "SELECT v FROM VentaCabecera v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "VentaCabecera.findByCondicionPago", query = "SELECT v FROM VentaCabecera v WHERE v.condicionPago = :condicionPago"),
    @NamedQuery(name = "VentaCabecera.findByImporteGravado", query = "SELECT v FROM VentaCabecera v WHERE v.importeGravado = :importeGravado"),
    @NamedQuery(name = "VentaCabecera.findByImporteIva", query = "SELECT v FROM VentaCabecera v WHERE v.importeIva = :importeIva"),
    @NamedQuery(name = "VentaCabecera.findByImporteExento", query = "SELECT v FROM VentaCabecera v WHERE v.importeExento = :importeExento"),
    @NamedQuery(name = "VentaCabecera.findByImporteTotal", query = "SELECT v FROM VentaCabecera v WHERE v.importeTotal = :importeTotal"),
    @NamedQuery(name = "VentaCabecera.findByEstadoVenta", query = "SELECT v FROM VentaCabecera v WHERE v.estadoVenta = :estadoVenta")})
public class VentaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "condicion_pago")
    private int condicionPago;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_venta")
    private Character estadoVenta;
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente")
    @ManyToOne(optional = false)
    private Cliente codigoCliente;
    @JoinColumn(name = "numero_pedido", referencedColumnName = "numero_pedido")
    @ManyToOne
    private PedidoCabecera numeroPedido;
    @JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo_vendedor")
    @ManyToOne(optional = false)
    private Vendedor codigoVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaCabecera")
    private List<VentaDetalle> ventaDetalleList;

    public VentaCabecera() {
    }

    public VentaCabecera(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public VentaCabecera(String numeroFactura, Date fechaVenta, int condicionPago, BigInteger importeGravado, BigInteger importeIva, BigInteger importeExento, BigInteger importeTotal, Character estadoVenta) {
        this.numeroFactura = numeroFactura;
        this.fechaVenta = fechaVenta;
        this.condicionPago = condicionPago;
        this.importeGravado = importeGravado;
        this.importeIva = importeIva;
        this.importeExento = importeExento;
        this.importeTotal = importeTotal;
        this.estadoVenta = estadoVenta;
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

    public int getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(int condicionPago) {
        this.condicionPago = condicionPago;
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

    public Character getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(Character estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public PedidoCabecera getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(PedidoCabecera numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Vendedor getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Vendedor codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    @XmlTransient
    public List<VentaDetalle> getVentaDetalleList() {
        return ventaDetalleList;
    }

    public void setVentaDetalleList(List<VentaDetalle> ventaDetalleList) {
        this.ventaDetalleList = ventaDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFactura != null ? numeroFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaCabecera)) {
            return false;
        }
        VentaCabecera other = (VentaCabecera) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.VentaCabecera[ numeroFactura=" + numeroFactura + " ]";
    }
    
}
