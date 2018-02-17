package org.home.web.auth.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.home.web.auth.models.Usuário;
import org.home.web.core.controllers.AbstractFacade;

/**
 *
 * @author igor
 */
@Stateless
public class UsuárioFacade extends AbstractFacade<Usuário> {

    @PersistenceContext
    private EntityManager em;

    public UsuárioFacade() {
        super(Usuário.class);
    }

    public Usuário verificarCredenciais(String login, String senha) {
        Usuário usuário = null;
        try {
            usuário = em.createNamedQuery("verificarCredenciais", Usuário.class)
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (NoResultException ex) {
            Logger.getLogger(UsuárioFacade.class.getName()).log(Level.WARNING, "Usuário não encontrado.");
        }
        return usuário;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
