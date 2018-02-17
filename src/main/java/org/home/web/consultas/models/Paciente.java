package org.home.web.consultas.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author igor
 */
@Entity
public class Paciente extends Pessoa {

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
