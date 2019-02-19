package fr.eni.sortir.servlets.participant;

import fr.eni.sortir.bll.ParticipantManager;
import fr.eni.sortir.bo.Participant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Servlet implementation class ParticipantServlet
 */
@WebServlet("/ParticipantServlet")
public class GestionParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ParticipantManager participantManager = new ParticipantManager();
	Participant participant;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionParticipantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "Tous les champs ne sont pas remplis";
		
		try {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String mail = request.getParameter("mail");
			String telephone = request.getParameter("telephone");
			
			if (!telephone.isEmpty() || !nom.isEmpty() || !prenom.isEmpty() || !mail.isEmpty()) {
				participant = participantManager.ajouter(nom, prenom, telephone, mail);
			}
			else {
				response.sendRedirect("/views/inscription?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			
						
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
