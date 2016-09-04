/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.sessions;

import com.gestionventas.entry.VentaCabecera;
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
public class VentaCabeceraFacade extends AbstractFacade<VentaCabecera> {

    @PersistenceContext(unitName = "GestionVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaCabeceraFacade() {
        super(VentaCabecera.class);
    }
    
    public String getFactura(){
        Query query = em.createNativeQuery("select select_factura(?1);");
        query.setParameter(1, 1);
        List lista = query.getResultList();
        if (!lista.isEmpty()){
            return lista.get(0).toString();
        }else return null;
    }
    
}
