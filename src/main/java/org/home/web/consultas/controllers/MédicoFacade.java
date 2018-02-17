package org.home.web.consultas.controllers;

import org.home.web.core.controllers.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.home.web.consultas.models.Médico;

/**
 *
 * @author igor
 */
@Stateless
public class MédicoFacade extends AbstractFacade<Médico> {

    @PersistenceContext(unitName = "WebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MédicoFacade() {
        super(Médico.class);
    }
    
}
