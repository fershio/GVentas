/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author guillermo.paez
 */
@Named
@SessionScoped
public class PlantillaController implements Serializable{
    public void verificarSesion(){
        try {
            //FacesContext context = FacesContext.getCurrentInstance();
            FacesContext context = SessionBean.getContext();
            //SessionBean.getSession().getAttribute("usuario")
            // Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if (SessionBean.getSession().getAttribute("usuario") ==  null){
                context.getExternalContext().redirect("permisos.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
