package org.home.web.consultas.controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.home.web.consultas.models.Médico;

/**
 *
 * @author igor
 */
@Named(value = "médicoBean")
@RequestScoped
public class MédicoBean {

    @EJB
    private MédicoFacade médicoFacade;
    private Médico médico;

    public MédicoBean() {
        médico = new Médico();
    }

    public Médico getMédico() {
        return médico;
    }

    public String cadastrarMédico() {
        médicoFacade.create(médico);
        médico = new Médico();
        return "";
    }

    public List<Médico> getMédicos() {
        return médicoFacade.findAll();
    }

}
