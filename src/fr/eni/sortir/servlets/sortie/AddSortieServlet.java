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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class Sortir
 */
@WebServlet(
        urlPatterns= {
                "/nouvelleSortie",
                "/editerSortie",
                "/annulerSortie"
        })
public class AddSortieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SortieManager sortieManager;
	private ParticipantManager participantManager;
	private LieuManager lieuManager;
	private SiteManager siteManager;
	private VilleManager villeManager;
	private Sortie sortie;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSortieServlet() {
        super();
        this.sortieManager = new SortieManager();
		this.participantManager = new ParticipantManager();
        this.lieuManager = new LieuManager();
        this.villeManager = new VilleManager();
        this.siteManager =  new SiteManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getServletPath().equals("/nouvelleSortie")) {

			request.setAttribute("title", "Ajouter");
			request.setAttribute("path", "nouvelleSortie");

            try {
                List<Lieu> Lieux = lieuManager.selectAll();
                request.setAttribute("listeLieux", Lieux);
            } catch (BusinessException e) {
                e.printStackTrace();
            }

            try {
                List<Ville> villes = villeManager.selectAll();
                request.setAttribute("listeVilles", villes);
            } catch (BusinessException e) {
                e.printStackTrace();
            }

            HttpSession session = request.getSession();
            int participantConnecte = (int) session.getAttribute("idParticipant");
            try {
                Participant participant = participantManager.afficher(participantConnecte);
                Site site = siteManager.selectById(participant.getSite());
                request.setAttribute("villeOrga", site.getNom());

            } catch (BusinessException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		// Afficher le formulaire de modification d'une sortie
		else if ((request.getServletPath().equals("/editerSortie")))
		{
			request.setAttribute("title", "Modifier");
			int idSortie= Integer.parseInt(request.getParameter("idSortie"));
			SortieManager sortieManager = new SortieManager();

			try {
				//affichage de la sortie en cours
				Sortie sortie = sortieManager.selectById(idSortie);
				request.setAttribute("sortie", sortie);
				request.setAttribute("path", "editerSortie");

			} catch (BusinessException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/formSortie.jsp");
			rd.forward(request, response);

		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerSortie.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Formulaire d'ajout d'une sortie
		if(request.getServletPath().equals("/nouvelleSortie")) {
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
				int participantConnecte = (int) session.getAttribute("idParticipant");
				nouvelleSortie.setOrganisateur(participantConnecte);

				String datedebut = request.getParameter("datedebut");
				String datefin = request.getParameter("datefin");

				datedebut = datedebut.replace('T', ' ');
				nouvelleSortie.setDateDebut(new SimpleDateFormat("yyyy-MM-dd H:m").parse(datedebut));
				nouvelleSortie.setDateLimiteInscription(new SimpleDateFormat("yyyy-MM-dd").parse(datefin));

				if (nouvelleSortie != null){
					sortie = sortieManager.ajouter(nouvelleSortie);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*// Formulaire de modification d'une sortie
		if(request.getServletPath().equals("/editerSortie"))
		{
			//Je lis les paramètres
			request.setCharacterEncoding("UTF-8");
			Sortie sortieUp = new Sortie();
			sortieUp.setIdSortie(Integer.parseInt(request.getParameter("idSortie")));
			sortieUp.setNom(request.getParameter("nom"));
			sortieUp.setUrlPhoto(request.getParameter("urlPhoto"));
			String dateString = request.getParameter("date");
			String heureString = request.getParameter("heure");
			String concateneeDateSortie=  dateString + " " + heureString;
			SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm");

			try {
				Date dateSortie = formatter6.parse(concateneeDateSortie);
				sortieUp.setDateHeureDebut(dateSortie);
				SimpleDateFormat formatter7=new SimpleDateFormat("yyyy-MM-dd");
				Date dateFin = formatter7.parse(request.getParameter("dateHeureFin"));
				sortieUp.setDateHeureFin(dateFin);
			} catch (ParseException e2) {
				e2.printStackTrace();

			}
			sortieUp.setDuree(Integer.parseInt(request.getParameter("duree")));
			sortieUp.setNbParticipantMax(Integer.parseInt(request.getParameter("nbParticipantMax")));
			sortieUp.setDescription(request.getParameter("description"));

			HttpSession session = request.getSession(true);
			Participant participantEnCours = (Participant) session.getAttribute("currentSessionParticipant");
			sortieUp.setOrganisateur(participantEnCours);

			Lieu lieuNew = new Lieu();
			lieuNew.setIdLieu(Integer.parseInt(request.getParameter("lieu")));
			sortieUp.setIdLieu(lieuNew);

			Etat etatNew = new Etat();
			etatNew.setIdEtat(Integer.parseInt(request.getParameter("etat")));
			sortieUp.setIdEtat(etatNew);

			SortieManager sortieManager = new SortieManager();
			try {

				sortieManager.update(sortieUp);
			} catch (BusinessException | SQLException e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/sorties");
			rd.forward(request, response);

		}*/
	}
}
