package org.home.web.consultas.models;

import javax.persistence.Entity;
import org.home.web.auth.models.Usuário;

/**
 *
 * @author igor
 */
@Entity
public class Pessoa extends Usuário {

    private String nome;
    private String endereço;
    private String cpf;
    private String telefoneFixo;
    private String telefoneCelular;

    public Pessoa() {
    }

    public Pessoa(String nome, String endereço, String cpf, String telefoneFixo, String telefoneCelular) {
        this.nome = nome;
        this.endereço = endereço;
        this.cpf = cpf;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
    }

    public Pessoa(String nome, String endereço, String cpf, String telefoneFixo, String telefoneCelular, String login, String senha) {
        super(login, senha);
        this.nome = nome;
        this.endereço = endereço;
        this.cpf = cpf;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

}
