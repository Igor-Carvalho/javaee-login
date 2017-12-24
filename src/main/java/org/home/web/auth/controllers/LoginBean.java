package org.home.web.auth.controllers;

import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.home.web.auth.models.Usuário;

/**
 *
 * @author igor
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @EJB
    private UsuárioFacade usuárioFacade;

    private String login;
    private String senha;
    private String next;
    private Boolean temErro = false;

    public LoginBean() {
    }

    public String logar() {
        Usuário usuário = usuárioFacade.verificarCredenciais(login, senha);
        if (usuário == null) {
            temErro = true;
            return "";
        } else {
            return logarUsuário(usuário);
        }
    }

    private String logarUsuário(Usuário usuário) {
        HttpServletRequest httpRequest = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
        httpRequest.getSession().setAttribute("userId", usuário.getId());
        return String.format("%s?faces-redirect=true", next);
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

    public String getNext() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.getOrDefault("next", "/app/index.faces");
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Boolean getTemErro() {
        return temErro;
    }

    public void setTemErro(Boolean temErro) {
        this.temErro = temErro;
    }

}
