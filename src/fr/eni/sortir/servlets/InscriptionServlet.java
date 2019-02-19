package fr.eni.sortir.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.sortir.bll.ParticipantManager;
import fr.eni.sortir.bo.Participant;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ParticipantManager participantManager = new ParticipantManager();
	Participant participant;
	
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/inscritpion.jsp");
		rd.forward(request, response);
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
