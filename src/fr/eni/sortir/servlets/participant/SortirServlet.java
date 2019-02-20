package fr.eni.sortir.servlets.participant;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.LieuManager;
import fr.eni.sortir.bll.SortieManager;
import fr.eni.sortir.bo.Lieu;
import fr.eni.sortir.bo.Sortie;

/**
 * Servlet implementation class Sortir
 */
@WebServlet("/Sortir")
public class SortirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SortieManager sortieManager = new SortieManager();
	Sortie sortie;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LieuManager lieuManager = new LieuManager();
			List<Lieu> listeLieux = lieuManager.selectAll();
			request.setAttribute("listeLieux", listeLieux);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerSortie.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nom = request.getParameter("nom");
			String dateDebut = request.getParameter("datedebut");
			String duree = request.getParameter("duree");
			String dateFin = request.getParameter("datefin");
			String nbInscription = request.getParameter("nbinscription");
			String infos = request.getParameter("infos");
			String photo = request.getParameter("photo");
			String organisateur = request.getParameter("organisateur");
			String etat = "Ouverte";
			int idEtat = 1;
			int idLieu = 1;
			
			sortie = sortieManager.ajouter(nom, Date.valueOf(dateDebut), Integer.valueOf(duree), Date.valueOf(dateFin), Integer.valueOf(nbInscription), infos, etat, photo, organisateur, idLieu, idEtat);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
