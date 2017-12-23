package org.home.web.auth.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author igor
 */
@Entity(name = "usuário")
@NamedQueries({
    @NamedQuery(name = "verificarCredenciais", query = "select u from usuário u where u.login = :login and u.senha = :senha"),
    @NamedQuery(name = "obterUsuário", query = "select u from usuário u where u.id = :id")
})
public class Usuário implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String login;
    private String senha;

    public Usuário() {
    }

    public Usuário(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.login);
        hash = 53 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Usuário)) {
            return false;
        }

        Usuário other = (Usuário) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.login, other.login)
                && Objects.equals(this.senha, other.senha);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", senha=" + senha + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
