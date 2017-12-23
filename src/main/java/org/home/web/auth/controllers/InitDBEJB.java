package org.home.web.auth.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.home.web.auth.models.Usuário;

/**
 * EJB para inicialização de usuários no db para testes.
 * 
 * @author igor
 */
@Singleton
@Startup
public class InitDBEJB {

    @PersistenceContext
    private EntityManager em;

    /**
     * Insere usuários no banco de dados.
     *
     */
    @PostConstruct
    public void inicializarUsuários() {
        long total = Long.parseLong(em.createQuery("select count(u) from usuário u").getSingleResult().toString());
        if (total == 0) {
            em.persist(new Usuário("user", "password"));
            em.persist(new Usuário("igor", "igor123"));
            em.persist(new Usuário("natan", "natan123"));
        }
    }
}
