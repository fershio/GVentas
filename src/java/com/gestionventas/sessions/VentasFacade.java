/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.sessions;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author guillermo.paez
 */
public class VentasFacade extends AbstractFacade<VentasFacade>{
    
    @PersistenceContext(unitName = "GestionVentasPU")
    private EntityManager em;

    public VentasFacade() {
        super(VentasFacade.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
