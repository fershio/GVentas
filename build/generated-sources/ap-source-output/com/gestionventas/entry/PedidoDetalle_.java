package com.gestionventas.entry;

import com.gestionventas.entry.PedidoCabecera;
import com.gestionventas.entry.PedidoDetallePK;
import com.gestionventas.entry.Producto;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(PedidoDetalle.class)
public class PedidoDetalle_ { 

    public static volatile SingularAttribute<PedidoDetalle, BigInteger> importeIva;
    public static volatile SingularAttribute<PedidoDetalle, BigInteger> importeExento;
    public static volatile SingularAttribute<PedidoDetalle, PedidoDetallePK> pedidoDetallePK;
    public static volatile SingularAttribute<PedidoDetalle, BigInteger> importeTotal;
    public static volatile SingularAttribute<PedidoDetalle, BigInteger> cantidad;
    public static volatile SingularAttribute<PedidoDetalle, Producto> producto;
    public static volatile SingularAttribute<PedidoDetalle, BigInteger> precioVenta;
    public static volatile SingularAttribute<PedidoDetalle, PedidoCabecera> pedidoCabecera;
    public static volatile SingularAttribute<PedidoDetalle, BigInteger> importeGravado;

}