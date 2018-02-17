package org.home.web.consultas.controllers;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.home.web.consultas.models.Consulta;

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
    private Long pacienteId;
    private Long médicoId;

    public ConsultaBean() {
        init();
    }
    
    private void init() {
        consulta = new Consulta();
        pacienteId = null;
        médicoId = null;
    }

    public String cadastrarConsulta() {
        consulta.setPaciente(pacienteFacade.find(pacienteId));
        consulta.setMédico(médicoFacade.find(médicoId));
        consultaFacade.create(consulta);
        init();
        return "";
    }
    
    public List<Consulta> getConsultas() {
        return consultaFacade.findAll();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMédicoId() {
        return médicoId;
    }

    public void setMédicoId(Long médicoId) {
        this.médicoId = médicoId;
    }

}
