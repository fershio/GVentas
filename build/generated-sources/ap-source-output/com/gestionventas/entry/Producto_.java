package com.gestionventas.entry;

import com.gestionventas.entry.PedidoDetalle;
import com.gestionventas.entry.PresupuestoDetalle;
import com.gestionventas.entry.VentaDetalle;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, BigInteger> stockMinimo;
    public static volatile SingularAttribute<Producto, Short> tipoImpuesto;
    public static volatile SingularAttribute<Producto, String> descripcionProducto;
    public static volatile SingularAttribute<Producto, BigInteger> costoProducto;
    public static volatile SingularAttribute<Producto, Integer> codigoProducto;
    public static volatile SingularAttribute<Producto, BigInteger> precioVenta;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile ListAttribute<Producto, VentaDetalle> ventaDetalleList;
    public static volatile ListAttribute<Producto, PresupuestoDetalle> presupuestoDetalleList;
    public static volatile ListAttribute<Producto, PedidoDetalle> pedidoDetalleList;

}