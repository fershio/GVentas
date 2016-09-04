package com.gestionventas.entry;

import com.gestionventas.entry.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-04T15:39:43")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Menu> codigoSubmenu;
    public static volatile SingularAttribute<Menu, Integer> codigo;
    public static volatile SingularAttribute<Menu, Character> tipo;
    public static volatile SingularAttribute<Menu, Character> estado;
    public static volatile SingularAttribute<Menu, Short> nivelUsuario;
    public static volatile SingularAttribute<Menu, String> orden;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, String> url;
    public static volatile CollectionAttribute<Menu, Menu> menuCollection;

}