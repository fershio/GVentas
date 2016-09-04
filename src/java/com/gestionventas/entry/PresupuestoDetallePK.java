/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.entry;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guille
 */
@Embeddable
public class PresupuestoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto_numero")
    private int presupuestoNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;

    public PresupuestoDetallePK() {
    }

    public PresupuestoDetallePK(int presupuestoNumero, int codigoProducto) {
        this.presupuestoNumero = presupuestoNumero;
        this.codigoProducto = codigoProducto;
    }

    public int getPresupuestoNumero() {
        return presupuestoNumero;
    }

    public void setPresupuestoNumero(int presupuestoNumero) {
        this.presupuestoNumero = presupuestoNumero;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) presupuestoNumero;
        hash += (int) codigoProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestoDetallePK)) {
            return false;
        }
        PresupuestoDetallePK other = (PresupuestoDetallePK) object;
        if (this.presupuestoNumero != other.presupuestoNumero) {
            return false;
        }
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.PresupuestoDetallePK[ presupuestoNumero=" + presupuestoNumero + ", codigoProducto=" + codigoProducto + " ]";
    }
    
}
