package com.gestionventas.entry;

import com.gestionventas.entry.Cliente;
import com.gestionventas.entry.PedidoCabecera;
import com.gestionventas.entry.Vendedor;
import com.gestionventas.entry.VentaDetalle;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(VentaCabecera.class)
public class VentaCabecera_ { 

    public static volatile SingularAttribute<VentaCabecera, BigInteger> importeIva;
    public static volatile SingularAttribute<VentaCabecera, BigInteger> importeExento;
    public static volatile SingularAttribute<VentaCabecera, BigInteger> importeTotal;
    public static volatile SingularAttribute<VentaCabecera, Character> estadoVenta;
    public static volatile SingularAttribute<VentaCabecera, Cliente> codigoCliente;
    public static volatile SingularAttribute<VentaCabecera, String> numeroFactura;
    public static volatile SingularAttribute<VentaCabecera, PedidoCabecera> numeroPedido;
    public static volatile SingularAttribute<VentaCabecera, Integer> condicionPago;
    public static volatile ListAttribute<VentaCabecera, VentaDetalle> ventaDetalleList;
    public static volatile SingularAttribute<VentaCabecera, BigInteger> importeGravado;
    public static volatile SingularAttribute<VentaCabecera, Date> fechaVenta;
    public static volatile SingularAttribute<VentaCabecera, Vendedor> codigoVendedor;

}