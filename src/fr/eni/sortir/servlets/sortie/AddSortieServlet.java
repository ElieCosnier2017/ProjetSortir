package fr.eni.sortir.servlets.sortie;

import fr.eni.sortir.bll.*;
import fr.eni.sortir.bo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class Sortir
 */
@WebServlet("/sortie/add")
public class AddSortieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SortieManager sortieManager;
	private LieuManager lieuManager;
	private VilleManager villeManager;
	private Sortie sortie;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSortieServlet() {
        super();
        this.sortieManager = new SortieManager();
        this.lieuManager = new LieuManager();
        this.villeManager = new VilleManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Lieu> Lieux = lieuManager.selectAll();
			request.setAttribute("listeLieux", Lieux);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		try {
			List<Ville> villes= villeManager.selectAll();
			request.setAttribute("listeVilles", villes);
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
			request.setCharacterEncoding("UTF-8");
			Sortie nouvelleSortie = new Sortie();

			nouvelleSortie.setNom(request.getParameter("nom"));
			nouvelleSortie.setidEtat(4);
			nouvelleSortie.setIdLieu(Integer.parseInt(request.getParameter("lieu")));
			nouvelleSortie.setInfosSortie(request.getParameter("infos"));
			nouvelleSortie.setDuree(Integer.parseInt(request.getParameter("duree")));
			nouvelleSortie.setNbInscriptionsMax(Integer.parseInt(request.getParameter("nbinscription")));
			HttpSession session = request.getSession();
			int participantConnecte = (int)session.getAttribute("idParticipant");
			nouvelleSortie.setOrganisateur(participantConnecte);

			String datedebut = request.getParameter("datedebut");
			String datefin = request.getParameter("datefin");

			datedebut = datedebut.replace('T', ' ');
			nouvelleSortie.setDateDebut(new SimpleDateFormat("yyyy-MM-dd H:m").parse(datedebut));
			nouvelleSortie.setDateLimiteInscription(new SimpleDateFormat("yyyy-MM-dd").parse(datefin));
			sortie = sortieManager.ajouter(nouvelleSortie);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
