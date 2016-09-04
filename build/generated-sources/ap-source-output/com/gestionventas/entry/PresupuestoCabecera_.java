package com.gestionventas.entry;

import com.gestionventas.entry.Cliente;
import com.gestionventas.entry.PresupuestoDetalle;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(PresupuestoCabecera.class)
public class PresupuestoCabecera_ { 

    public static volatile SingularAttribute<PresupuestoCabecera, BigInteger> totalPresupuesto;
    public static volatile SingularAttribute<PresupuestoCabecera, Cliente> codigoCliente;
    public static volatile SingularAttribute<PresupuestoCabecera, Integer> numeroPresupuesto;
    public static volatile SingularAttribute<PresupuestoCabecera, Date> fechaPresupuesto;
    public static volatile ListAttribute<PresupuestoCabecera, PresupuestoDetalle> presupuestoDetalleList;

}