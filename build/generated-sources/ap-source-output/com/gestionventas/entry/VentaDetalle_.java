package com.gestionventas.entry;

import com.gestionventas.entry.Producto;
import com.gestionventas.entry.VentaCabecera;
import com.gestionventas.entry.VentaDetallePK;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(VentaDetalle.class)
public class VentaDetalle_ { 

    public static volatile SingularAttribute<VentaDetalle, BigInteger> importeExento;
    public static volatile SingularAttribute<VentaDetalle, BigInteger> importeIva5;
    public static volatile SingularAttribute<VentaDetalle, BigInteger> importeTotal;
    public static volatile SingularAttribute<VentaDetalle, VentaCabecera> ventaCabecera;
    public static volatile SingularAttribute<VentaDetalle, BigInteger> cantidad;
    public static volatile SingularAttribute<VentaDetalle, BigInteger> importeIva10;
    public static volatile SingularAttribute<VentaDetalle, Producto> producto;
    public static volatile SingularAttribute<VentaDetalle, Integer> precioVenta;
    public static volatile SingularAttribute<VentaDetalle, BigInteger> importeGravado;
    public static volatile SingularAttribute<VentaDetalle, VentaDetallePK> ventaDetallePK;

}