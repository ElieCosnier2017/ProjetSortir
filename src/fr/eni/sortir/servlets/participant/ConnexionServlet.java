package fr.eni.sortir.servlets.participant;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.ConnexionManager;
import fr.eni.sortir.bo.Participant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        if(email != null && mdp != null) {
            ConnexionManager connexionManager = new ConnexionManager();
            try {
               Participant participant =  connexionManager.getParticipant(email, mdp);
               if(participant != null){
                   HttpSession session = request.getSession();
                   session.setAttribute("idParticipant", participant.getIdparticipant());
                   response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
                   response.setHeader("Location", "/");
               } else {
                   //TODO afficher message si pas de resultat
               }
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/connexion.jsp");
        rd.forward(request, response);
    }
}