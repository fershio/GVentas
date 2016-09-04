/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionventas.sessions;

import com.gestionventas.entry.PresupuestoDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guille
 */
@Stateless
public class PresupuestoDetalleFacade extends AbstractFacade<PresupuestoDetalle> {

    @PersistenceContext(unitName = "GestionVentasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoDetalleFacade() {
        super(PresupuestoDetalle.class);
    }
    
}
