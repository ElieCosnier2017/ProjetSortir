package fr.eni.sortir.servlets.participant;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.ConnexionManager;
import fr.eni.sortir.bo.Participant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        String rememberMe = request.getParameter("remember");
        if(email != null && mdp != null) {
            ConnexionManager connexionManager = new ConnexionManager();
            try {
               Participant participant =  connexionManager.getParticipant(email, mdp);
               if(participant != null){
                   HttpSession session = request.getSession();
                   session.setAttribute("participant", participant);
                   response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                   response.setHeader("Location", "/");
                   if(rememberMe != null){
                        rememberParticipant(request, response, email);
                   }
               } else {
                   request.setCharacterEncoding("UTF-8");
                   request.setAttribute("erreur" , "Le login / mot de passe n'est pas bon");
                   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/connexion.jsp");
                   rd.forward(request, response);
               }
            } catch (BusinessException | ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String rememberParticipant(HttpServletRequest request, HttpServletResponse response, String login) {
        Cookie[] cookies = request.getCookies();

        for(Cookie cookie : cookies){
            if("loginParticipant".equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        if(login != null){
            response.addCookie(createCookie("loginParticipant", login));
        }
        return login;
    }

    private Cookie createCookie(String cookieName, String parameter){
        Cookie unCookie = new Cookie(cookieName, parameter);
        unCookie.setMaxAge(3600);
        return unCookie;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginParticipant" ,  rememberParticipant(request, response, null));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/connexion.jsp");
        rd.forward(request, response);
    }
}