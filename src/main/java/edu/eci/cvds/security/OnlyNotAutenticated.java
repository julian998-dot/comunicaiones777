package edu.eci.cvds.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class OnlyNotAutenticated extends AccessControlFilter {

    String welcomeurlAdmin = "/faces/admin/pages/cambiarEstadoRecurso.xhtml ";
    String welcomeurlRegular = "/faces/regular/pages/consultarRecursos.xhtml ";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        return !subject.isAuthenticated(); // THE POINT

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject.hasRole("administrador")) {
            WebUtils.issueRedirect(request, response, welcomeurlAdmin);
        }else{
            WebUtils.issueRedirect(request, response, welcomeurlRegular);
        }
        return false;//What to do if try to go to login -> go welcome page of auth ursers
    }
}
