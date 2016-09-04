/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.sessions;

import com.gestionventas.entry.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Guille
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "GestionVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciarSesion(Usuario us,List<Usuario> lista){


        try{
            /*consulta =  "SELECT u FROM public.usuario u where u.usuario = ?1  and u.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUser());
            query.setParameter(2, us.getPassword());
            lista =    query.getResultList();*/
            boolean validado = false;
            if (!lista.isEmpty()){
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getUser().equals(us.getUser()) &&
                            lista.get(i).getPassword().equals(us.getPassword()))
                        return lista.get(i);
                    else validado = false;
                }
            }else return null;
            if (!validado) return null;
        }catch (Exception e){
            throw e;
        }finally{
            //em.close();
        }
        return null;
    }
    
}
