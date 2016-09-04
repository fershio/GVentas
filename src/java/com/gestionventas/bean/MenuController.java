/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.bean;

import com.gestionventas.entry.Menu;
import com.gestionventas.entry.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author guillermo.paez
 */
@Named(value = "menuController")
@SessionScoped
public class MenuController implements Serializable{

    @EJB
    private com.gestionventas.sessions.MenuFacade EJBMenu;
    private List<Menu> lista;
    private MenuModel model;
    
    @PostConstruct
    public void init(){
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }
    
    public void listarMenus(){
        try {
            lista = EJBMenu.findAll();
        } catch (Exception e) {
        } 
    }
    
    public void establecerPermisos(){
        try {
            //Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            HttpSession session = SessionBean.getSession();
            Short nivel = (Short) session.getAttribute("nivel");
            
            for (Menu m : lista)
            {
                if (m.getTipo().equals('S') && m.getNivelUsuario()== nivel){
                    DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                    for (Menu i : lista) {
                        Menu submenu = i.getCodigoSubmenu();
                        if (submenu != null) {
                            if (Objects.equals(submenu.getCodigo(), m.getCodigo())) {
                                DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                                item.setCommand(i.getUrl());
                                //item.setUrl("/view/form/Ventas.xhtml?faces-redirect=true");
                                //item.setCommand("/view/form/Ventas.xhtml");
                                firstSubmenu.addElement(item);
                            }
                        }
                    }
                    model.addElement(firstSubmenu);
                }else{
                    if (m.getCodigoSubmenu() == null && m.getNivelUsuario()== nivel){
                        DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                        item.setCommand(m.getUrl());
                        //item.setUrl("/view/form/Ventas.xhtml?faces-redirect=true");
                        //item.setCommand("/view/form/Ventas.xhtml");
                        model.addElement(item);
                    }
                }
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
}
