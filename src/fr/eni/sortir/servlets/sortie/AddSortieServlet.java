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
import java.io.UnsupportedEncodingException;
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
                "/sortie/ajouter",
                "/sortie/editer",
                "/sortie/annuler"
        })
public class AddSortieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SortieManager sortieManager;
	private ParticipantManager participantManager;
	private LieuManager lieuManager;
	private SiteManager siteManager;
	private VilleManager villeManager;
	private EtatManager etatManager;
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
        this.etatManager = new EtatManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getServletPath().equals("/sortie/ajouter")) {

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
				List<Etat> etats = etatManager.selectAll();
				request.setAttribute("listeEtats", etats);

            } catch (BusinessException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		// Afficher le formulaire de modification d'une sortie
		else if ((request.getServletPath().equals("/sortie/editer")))
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
		if(request.getServletPath().equals("/sortie/ajouter")) {
			try {
				request.setCharacterEncoding("UTF-8");
				Sortie nouvelleSortie = this.getParameters(request, true);

				if (nouvelleSortie != null){
					sortie = sortieManager.ajouter(nouvelleSortie);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Formulaire de modification d'une sortie
		if(request.getServletPath().equals("/editerSortie"))
		{
			try {
				request.setCharacterEncoding("UTF-8");
				Sortie nouvelleSortie = this.getParameters(request, false);

				if (nouvelleSortie != null){
					sortie = sortieManager.update(nouvelleSortie);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/sorties");
			rd.forward(request, response);

		}
	}

	private Sortie getParameters(HttpServletRequest request, boolean isCreation) throws UnsupportedEncodingException, ParseException {
		request.setCharacterEncoding("UTF-8");
		Sortie nouvelleSortie = new Sortie();
		nouvelleSortie.setNom(request.getParameter("nom"));
		if(isCreation){
			nouvelleSortie.setidEtat(4);
		}
		else {
			nouvelleSortie.setidEtat(Integer.parseInt(request.getParameter("etat")));
		}
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

		return nouvelleSortie;
	}
}
