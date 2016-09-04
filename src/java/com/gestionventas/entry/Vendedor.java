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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByCodigoVendedor", query = "SELECT v FROM Vendedor v WHERE v.codigoVendedor = :codigoVendedor"),
    @NamedQuery(name = "Vendedor.findByNombreVendedor", query = "SELECT v FROM Vendedor v WHERE v.nombreVendedor = :nombreVendedor"),
    @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion"),
    @NamedQuery(name = "Vendedor.findByDocumento", query = "SELECT v FROM Vendedor v WHERE v.documento = :documento"),
    @NamedQuery(name = "Vendedor.findByTelefono", query = "SELECT v FROM Vendedor v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "Vendedor.findByActivo", query = "SELECT v FROM Vendedor v WHERE v.activo = :activo")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_vendedor")
    private Integer codigoVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_vendedor")
    private String nombreVendedor;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 15)
    @Column(name = "documento")
    private String documento;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private Character activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoVendedor")
    private List<VentaCabecera> ventaCabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoVendedor")
    private List<Cliente> clienteList;

    public Vendedor() {
    }

    public Vendedor(Integer codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public Vendedor(Integer codigoVendedor, String nombreVendedor, Character activo) {
        this.codigoVendedor = codigoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.activo = activo;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Integer codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<VentaCabecera> getVentaCabeceraList() {
        return ventaCabeceraList;
    }

    public void setVentaCabeceraList(List<VentaCabecera> ventaCabeceraList) {
        this.ventaCabeceraList = ventaCabeceraList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVendedor != null ? codigoVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codigoVendedor == null && other.codigoVendedor != null) || (this.codigoVendedor != null && !this.codigoVendedor.equals(other.codigoVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.Vendedor[ codigoVendedor=" + codigoVendedor + " ]";
    }
    
}
