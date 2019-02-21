package fr.eni.sortir.servlets.sortie;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.EtatManager;
import fr.eni.sortir.bll.LieuManager;
import fr.eni.sortir.bll.SortieManager;
import fr.eni.sortir.bo.Etat;
import fr.eni.sortir.bo.Lieu;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Sortie;

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
	private EtatManager etatManager;
	private Sortie sortie;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSortieServlet() {
        super();
        this.sortieManager = new SortieManager();
        this.lieuManager = new LieuManager();
        this.etatManager = new EtatManager();
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
			List<Etat> etats= etatManager.selectAll();
			request.setAttribute("listeEtats", etats);
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
			nouvelleSortie.setDuree(Integer.parseInt(request.getParameter("duree")));
			nouvelleSortie.setNbInscriptionsMax(Integer.parseInt(request.getParameter("nbinscription")));
			nouvelleSortie.setInfosSortie(request.getParameter("infos"));
			nouvelleSortie.setPhoto(request.getParameter("photo"));
			nouvelleSortie.setIdLieu(Integer.parseInt(request.getParameter("lieu")));
			System.out.println(request.getParameter("datedebut"));

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date datedebut = formatter.parse(request.getParameter("datedebut"));
				nouvelleSortie.setDateDebut((java.sql.Date) datedebut);
				Date datefin = formatter.parse(request.getParameter("datefin"));
				nouvelleSortie.setDateLimiteInscription((java.sql.Date) datefin);
			} catch (ParseException e2) {
				e2.printStackTrace();

			}

			int idEtat = Integer.parseInt(request.getParameter("etat"));
			nouvelleSortie.setEtat(etatManager.selectById(idEtat).getLibelle());
			nouvelleSortie.setidEtat(idEtat);

			HttpSession session = request.getSession();
			int participantConnecte = (int)session.getAttribute("idParticipant");
			nouvelleSortie.setOrganisateur(participantConnecte);

			sortie = sortieManager.ajouter(nouvelleSortie);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
