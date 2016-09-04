/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUser", query = "SELECT u FROM Usuario u WHERE u.user = :user"),
    @NamedQuery(name = "Usuario.findByUserName", query = "SELECT u FROM Usuario u WHERE u.userName = :userName"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByNivelUsuario", query = "SELECT u FROM Usuario u WHERE u.nivelUsuario = :nivelUsuario"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usuario")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel_usuario")
    private short nivelUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;

    public Usuario() {
    }

    public Usuario(String user) {
        this.user = user;
    }

    public Usuario(String user, String userName, String password, short nivelUsuario, Character estado) {
        this.user = user;
        this.userName = userName;
        this.password = password;
        this.nivelUsuario = nivelUsuario;
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user)));
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.Usuario[ user=" + user + " ]";
    }
    
    
     
    
}
