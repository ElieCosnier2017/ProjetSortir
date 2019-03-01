package fr.eni.sortir.servlets.participant;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.ParticipantManager;
import fr.eni.sortir.bll.SiteManager;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Site;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class ParticipantServlet
 */
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParticipantManager participantManager;

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
		Participant idparticipant = (Participant) session.getAttribute("participant");
		SiteManager siteManager = new SiteManager();

		try {
			List<Site> siteList = siteManager.selectAll();
			request.setAttribute("listeSite", siteList);
			request.setAttribute("participant", participantManager.afficher(idparticipant.getIdparticipant()));
		} catch (BusinessException | SQLException e) {
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
		Participant participant = (Participant) httpSession.getAttribute("participant");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String pseudo = request.getParameter("pseudo");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confpassword");
		String idSite = request.getParameter("ville");

		if(password.equals("")) {
			password = participant.getPassword();
		}

		try {
			participant = new Participant(participant.getIdparticipant(), nom, prenom, telephone, mail, pseudo, password, Integer.parseInt(idSite));
			participantManager.modifier(participant);
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "/profil");
		} catch (BusinessException | SQLException e) {
			e.printStackTrace();
		}
	}

}
