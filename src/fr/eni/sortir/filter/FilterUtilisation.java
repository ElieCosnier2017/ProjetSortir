package fr.eni.sortir.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        dispatcherTypes = {
                DispatcherType.REQUEST,
                DispatcherType.FORWARD,
                DispatcherType.INCLUDE,
                DispatcherType.ERROR
        }
        ,
        urlPatterns = {
                "/sortie/*",
                "/profil",
                "/ville/*",
                "/site/*",
                "/detail",
                "/user/*"
        })
public class FilterUtilisation implements Filter {

    /**
     * Default constructor.
     */
    public FilterUtilisation() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        boolean conditionUtilisation = false;

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession();

        if(session != null) {
            if(session.getAttribute("participant") != null) {
                conditionUtilisation = true;
            }
        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(conditionUtilisation == false) {
            httpResponse.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            httpResponse.setHeader("Location", "/connexion");

        }else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }



}
