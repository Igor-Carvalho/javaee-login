package org.home.web.consultas.controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.home.web.consultas.models.Paciente;

/**
 *
 * @author igor
 */
@Named(value = "pacienteBean")
@RequestScoped
public class PacienteBean {

    @EJB
    private PacienteFacade pacienteFacade;
    private Paciente paciente;

    public PacienteBean() {
        paciente = new Paciente();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String cadastrarPaciente() {
        pacienteFacade.create(paciente);
        paciente = new Paciente();
        return "";
    }

    public List<Paciente> getPacientes() {
        return pacienteFacade.findAll();
    }

}
