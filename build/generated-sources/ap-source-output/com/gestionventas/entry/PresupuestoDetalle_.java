package com.gestionventas.entry;

import com.gestionventas.entry.PresupuestoCabecera;
import com.gestionventas.entry.PresupuestoDetallePK;
import com.gestionventas.entry.Producto;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(PresupuestoDetalle.class)
public class PresupuestoDetalle_ { 

    public static volatile SingularAttribute<PresupuestoDetalle, BigInteger> total;
    public static volatile SingularAttribute<PresupuestoDetalle, PresupuestoDetallePK> presupuestoDetallePK;
    public static volatile SingularAttribute<PresupuestoDetalle, BigInteger> precioPresupuesto;
    public static volatile SingularAttribute<PresupuestoDetalle, BigInteger> cantidad;
    public static volatile SingularAttribute<PresupuestoDetalle, Producto> producto;
    public static volatile SingularAttribute<PresupuestoDetalle, PresupuestoCabecera> presupuestoCabecera;

}