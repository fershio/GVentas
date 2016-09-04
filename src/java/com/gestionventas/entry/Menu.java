/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author guillermo.paez
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m order by m.orden asc"),
    @NamedQuery(name = "Menu.findByCodigo", query = "SELECT m FROM Menu m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Menu.findByNombre", query = "SELECT m FROM Menu m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Menu.findByTipo", query = "SELECT m FROM Menu m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Menu.findByNivelUsuario", query = "SELECT m FROM Menu m WHERE m.nivelUsuario = :nivelUsuario"),
    @NamedQuery(name = "Menu.findByEstado", query = "SELECT m FROM Menu m WHERE m.estado = :estado"),
    @NamedQuery(name = "Menu.findByOrden", query = "SELECT m FROM Menu m WHERE m.orden = :orden")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel_usuario")
    private short nivelUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Size(max = 10)
    @Column(name = "orden")
    private String orden;
    @Column(name = "url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    @OneToMany(mappedBy = "codigoSubmenu")
    private Collection<Menu> menuCollection;
    @JoinColumn(name = "codigo_submenu", referencedColumnName = "codigo")
    @ManyToOne
    private Menu codigoSubmenu;

    public Menu() {
    }

    public Menu(Integer codigo) {
        this.codigo = codigo;
    }

    public Menu(Integer codigo, String nombre, Character tipo, short nivelUsuario, Character estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivelUsuario = nivelUsuario;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public short getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(short nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    public Menu getCodigoSubmenu() {
        return codigoSubmenu;
    }

    public void setCodigoSubmenu(Menu codigoSubmenu) {
        this.codigoSubmenu = codigoSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.Menu[ codigo=" + codigo + " ]";
    }
    
}
