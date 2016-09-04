/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodigoCliente", query = "SELECT c FROM Cliente c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "Cliente.findByRazonSocial", query = "SELECT c FROM Cliente c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cliente.findByRuc", query = "SELECT c FROM Cliente c WHERE c.ruc = :ruc"),
    @NamedQuery(name = "Cliente.findByCedula", query = "SELECT c FROM Cliente c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByLongitud", query = "SELECT c FROM Cliente c WHERE c.longitud = :longitud"),
    @NamedQuery(name = "Cliente.findByLatitud", query = "SELECT c FROM Cliente c WHERE c.latitud = :latitud")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_cliente")
    private Integer codigoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 20)
    @Column(name = "longitud")
    private String longitud;
    @Size(max = 20)
    @Column(name = "latitud")
    private String latitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCliente")
    private List<VentaCabecera> ventaCabeceraList;
    @JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo_vendedor")
    @ManyToOne(optional = false)
    private Vendedor codigoVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCliente")
    private List<PresupuestoCabecera> presupuestoCabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCliente")
    private List<PedidoCabecera> pedidoCabeceraList;

    public Cliente() {
    }

    public Cliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente(Integer codigoCliente, String razonSocial, String ruc, String cedula) {
        this.codigoCliente = codigoCliente;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.cedula = cedula;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @XmlTransient
    public List<VentaCabecera> getVentaCabeceraList() {
        return ventaCabeceraList;
    }

    public void setVentaCabeceraList(List<VentaCabecera> ventaCabeceraList) {
        this.ventaCabeceraList = ventaCabeceraList;
    }

    public Vendedor getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Vendedor codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    @XmlTransient
    public List<PresupuestoCabecera> getPresupuestoCabeceraList() {
        return presupuestoCabeceraList;
    }

    public void setPresupuestoCabeceraList(List<PresupuestoCabecera> presupuestoCabeceraList) {
        this.presupuestoCabeceraList = presupuestoCabeceraList;
    }

    @XmlTransient
    public List<PedidoCabecera> getPedidoCabeceraList() {
        return pedidoCabeceraList;
    }

    public void setPedidoCabeceraList(List<PedidoCabecera> pedidoCabeceraList) {
        this.pedidoCabeceraList = pedidoCabeceraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.Cliente[ codigoCliente=" + codigoCliente + " ]";
    }
    
}
