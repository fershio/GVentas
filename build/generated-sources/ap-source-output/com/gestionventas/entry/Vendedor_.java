package com.gestionventas.entry;

import com.gestionventas.entry.Cliente;
import com.gestionventas.entry.VentaCabecera;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, String> nombreVendedor;
    public static volatile ListAttribute<Vendedor, Cliente> clienteList;
    public static volatile SingularAttribute<Vendedor, String> direccion;
    public static volatile SingularAttribute<Vendedor, String> documento;
    public static volatile ListAttribute<Vendedor, VentaCabecera> ventaCabeceraList;
    public static volatile SingularAttribute<Vendedor, String> telefono;
    public static volatile SingularAttribute<Vendedor, Integer> codigoVendedor;
    public static volatile SingularAttribute<Vendedor, Character> activo;

}