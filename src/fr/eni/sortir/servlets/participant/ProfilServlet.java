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
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ParticipantManager participantManager = new ParticipantManager();
	private Participant participant;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idparticipant;
		HttpSession httpSession = request.getSession();
 		idparticipant = (int) httpSession.getAttribute("idParticipant");
		try {
			request.setAttribute("participant", participantManager.afficher(idparticipant));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/profil.jsp");
		rd.forward(request, response);
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


		if (password.isEmpty()){
			try {
				participant = new Participant(idparticipant, nom, prenom, mail, telephone, pseudo);
				participantManager.modifier(participant);
			} catch (BusinessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
