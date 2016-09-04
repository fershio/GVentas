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
import javax.validation.constraints.Size;

/**
 *
 * @author guillermo.paez
 */
@Embeddable
public class VentaDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;

    public VentaDetallePK() {
    }

    public VentaDetallePK(String numeroFactura, int codigoProducto) {
        this.numeroFactura = numeroFactura;
        this.codigoProducto = codigoProducto;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
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
        hash += (numeroFactura != null ? numeroFactura.hashCode() : 0);
        hash += (int) codigoProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetallePK)) {
            return false;
        }
        VentaDetallePK other = (VentaDetallePK) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.VentaDetallePK[ numeroFactura=" + numeroFactura + ", codigoProducto=" + codigoProducto + " ]";
    }
    
}
