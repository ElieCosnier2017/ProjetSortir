package fr.eni.sortir.servlets.participant;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.ParticipantManager;
import fr.eni.sortir.bo.Participant;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		Boolean admin = false;
		Boolean actif = true;
			
		if(nom!= null && prenom!=null && mail !=null && pseudo!=null && password!=null) {
			ParticipantManager participantManager = new ParticipantManager();
			Participant participant = null;
			try {
				participant = participantManager.ajouter(nom, prenom, telephone, mail, pseudo, password, admin, actif);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			if(participant != null){
				response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", "/");

			} else {
				//TODO afficher message si pas de resultat
			}
		}
	}
}


