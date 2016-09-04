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
public class PedidoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_pedido")
    private int numeroPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;

    public PedidoDetallePK() {
    }

    public PedidoDetallePK(int numeroPedido, int codigoProducto) {
        this.numeroPedido = numeroPedido;
        this.codigoProducto = codigoProducto;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
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
        hash += (int) numeroPedido;
        hash += (int) codigoProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetallePK)) {
            return false;
        }
        PedidoDetallePK other = (PedidoDetallePK) object;
        if (this.numeroPedido != other.numeroPedido) {
            return false;
        }
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionventas.entry.PedidoDetallePK[ numeroPedido=" + numeroPedido + ", codigoProducto=" + codigoProducto + " ]";
    }
    
}
