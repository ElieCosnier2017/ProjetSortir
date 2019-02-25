package fr.eni.sortir.servlets.participant;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.ParticipantManager;
import fr.eni.sortir.bo.Participant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * Servlet implementation class ParticipantServlet
 */
@WebServlet("/profiltest")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ParticipantManager participantManager;
	private Participant participant;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
		participantManager = new ParticipantManager();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idparticipant = 0;

		if(!session.isNew()) {
			idparticipant = (int) session.getAttribute("idParticipant");

			try {
				request.setAttribute("participant", participantManager.afficher(idparticipant));
			} catch (BusinessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/profil.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("pas de connexion");
		}

//		if (idparticipant == 0) {
//			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//			response.setHeader("Location", "/connexion");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		int idparticipant = (int) httpSession.getAttribute("idParticipant");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confpassword");
		System.out.println(nom + ' '+prenom+' '+mail+' '+telephone+' '+pseudo);

		if(password == null) {
			Participant oldparticipant = (Participant) request.getAttribute("participant");
			password = oldparticipant.getPassword();
		}

		try {
			participant = new Participant(idparticipant, nom, prenom, telephone, mail, pseudo, password);
			participantManager.modifier(participant);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

}
