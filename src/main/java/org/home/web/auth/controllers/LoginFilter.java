package org.home.web.auth.controllers;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.home.web.auth.models.Usuário;

/**
 *
 * @author igor
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/app/*"}, initParams = {
    @WebInitParam(name = "páginaLogin", value = "/login.faces"),
    @WebInitParam(name = "próximaPágina", value = "next")
})
public class LoginFilter implements Filter {

    @EJB
    private UsuárioFacade usuárioFacade;
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    /**
     * Verifica se existe uma ID de usuário na sessão. Caso não exista, ou exista e não corresponda a um
     * usuário válido, redireciona para página de login.
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        Object userId = session.getAttribute("userId");

        if (userId == null) {
            redirectToLoginPage(httpRequest, httpResponse);
        } else {
            Usuário usuário = usuárioFacade.find(Long.parseLong(userId.toString()));
            if (usuário == null) {
                redirectToLoginPage(httpRequest, httpResponse);
            } else {
                httpRequest.setAttribute("usuário", usuário);
                chain.doFilter(httpRequest, httpResponse);
            }
        }
    }

    protected void redirectToLoginPage(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        String páginaLogin = filterConfig.getInitParameter("páginaLogin");
        httpResponse.sendRedirect(String.format("%s?next=%s", páginaLogin, httpRequest.getRequestURI()));
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
