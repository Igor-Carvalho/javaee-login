package org.home.web.auth.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.home.web.consultas.models.Atendente;

/**
 * EJB para inicialização de usuários no db para testes.
 *
 * @author igor
 */
@Singleton
@Startup
public class InitDBEJB {

    @EJB
    private UsuárioFacade usuárioFacade;

    /**
     * Insere usuários no banco de dados.
     *
     */
    @PostConstruct
    public void inicializarUsuários() {
        long total = usuárioFacade.count();
        if (total == 0) {
            Atendente igor = new Atendente();
            igor.setLogin("igor");
            igor.setSenha("igor123");
            igor.setNome("Igor Carvalho");
            usuárioFacade.create(igor);
        }
    }
}
