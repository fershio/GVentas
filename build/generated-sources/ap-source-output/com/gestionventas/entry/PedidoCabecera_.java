package com.gestionventas.entry;

import com.gestionventas.entry.Cliente;
import com.gestionventas.entry.PedidoDetalle;
import com.gestionventas.entry.VentaCabecera;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(PedidoCabecera.class)
public class PedidoCabecera_ { 

    public static volatile SingularAttribute<PedidoCabecera, BigInteger> importeIva;
    public static volatile SingularAttribute<PedidoCabecera, BigInteger> importeExento;
    public static volatile SingularAttribute<PedidoCabecera, BigInteger> importeTotal;
    public static volatile SingularAttribute<PedidoCabecera, Cliente> codigoCliente;
    public static volatile ListAttribute<PedidoCabecera, VentaCabecera> ventaCabeceraList;
    public static volatile SingularAttribute<PedidoCabecera, Integer> numeroPedido;
    public static volatile SingularAttribute<PedidoCabecera, Date> fechaPedido;
    public static volatile SingularAttribute<PedidoCabecera, BigInteger> importeGravado;
    public static volatile ListAttribute<PedidoCabecera, PedidoDetalle> pedidoDetalleList;
    public static volatile SingularAttribute<PedidoCabecera, Integer> codigoVendedor;

}