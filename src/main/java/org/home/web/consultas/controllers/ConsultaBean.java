package org.home.web.consultas.controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.home.web.consultas.models.Consulta;
import org.home.web.consultas.models.Médico;
import org.home.web.consultas.models.Paciente;

/**
 *
 * @author igor
 */
@Named(value = "consultaBean")
@RequestScoped
public class ConsultaBean {

    @EJB
    private ConsultaFacade consultaFacade;
    @EJB
    private PacienteFacade pacienteFacade;
    @EJB
    private MédicoFacade médicoFacade;
    private Consulta consulta;

    public ConsultaBean() {
        consulta = new Consulta();
    }

    public String cadastrarConsulta() {
        consultaFacade.create(consulta);
        consulta = new Consulta();
        return "";
    }

    public List<Consulta> getConsultas() {
        return consultaFacade.findAll();
    }

    public ConsultaFacade getConsultaFacade() {
        return consultaFacade;
    }

    public void setConsultaFacade(ConsultaFacade consultaFacade) {
        this.consultaFacade = consultaFacade;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Paciente> getPacientes() {
        return pacienteFacade.findAll();
    }

    public List<Médico> getMédicos() {
        return médicoFacade.findAll();
    }

}
