package com.gestionventas.entry;

import com.gestionventas.entry.PedidoCabecera;
import com.gestionventas.entry.PresupuestoCabecera;
import com.gestionventas.entry.Vendedor;
import com.gestionventas.entry.VentaCabecera;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> ruc;
    public static volatile SingularAttribute<Cliente, String> latitud;
    public static volatile SingularAttribute<Cliente, String> razonSocial;
    public static volatile SingularAttribute<Cliente, String> longitud;
    public static volatile SingularAttribute<Cliente, String> cedula;
    public static volatile ListAttribute<Cliente, PedidoCabecera> pedidoCabeceraList;
    public static volatile SingularAttribute<Cliente, Integer> codigoCliente;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile ListAttribute<Cliente, VentaCabecera> ventaCabeceraList;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile ListAttribute<Cliente, PresupuestoCabecera> presupuestoCabeceraList;
    public static volatile SingularAttribute<Cliente, Vendedor> codigoVendedor;

}