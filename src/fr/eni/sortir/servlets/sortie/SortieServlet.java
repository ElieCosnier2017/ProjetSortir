package fr.eni.sortir.servlets.sortie;

import fr.eni.sortir.bll.*;
import fr.eni.sortir.bo.Etat;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Sortie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SortieServlet
 */
@WebServlet("/sortie")
public class SortieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortieServlet() throws BusinessException {
        super();
		SortieManager sortieManager = new SortieManager();
		sortieManager.sortiesBySite(1);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			Participant connecter = (Participant) session.getAttribute("participant");


			out.println(json_sortie(1, connecter).toJSONString());


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private JSONObject json_sortie(int idSite, Participant connecter){
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObject = new JSONObject();
		SortieManager sortieManager = new SortieManager();
		InscriptionManager inscriptionManager = new InscriptionManager();
		EtatManager etatManager = new EtatManager();
		ParticipantManager participantManager = new ParticipantManager();

		try {
			List<Sortie> listSortie = sortieManager.sortiesBySite(idSite);
			for (Sortie sortie: listSortie) {
				int nbinscrit = inscriptionManager.countinscrit(sortie.getIdSortie());
				Etat etatLibelle = etatManager.selectById(sortie.getIdEtat());
				Participant organisateur = participantManager.afficher(sortie.getOrganisateur());

				Boolean inscrit = inscriptionManager.isInscrit(sortie.getIdSortie(),connecter.getIdparticipant());

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("no_sortie", sortie.getIdSortie());
				jsonObject.put("nom", sortie.getNom());
				jsonObject.put("dateDebut", sortie.getDateDebut().toString());
				jsonObject.put("duree", sortie.getDuree());
				jsonObject.put("dateLimiteInscription", sortie.getDateLimiteInscription().toString());
				jsonObject.put("nbInscrit", nbinscrit);
				jsonObject.put("nbMax", sortie.getNbInscriptionsMax());
				jsonObject.put("idEtat", etatLibelle.getIdEtat());
				jsonObject.put("libelleEtat", etatLibelle.getLibelle());
				jsonObject.put("isInscrit", inscrit);
				jsonObject.put("idConnecter", connecter.getIdparticipant());
				jsonObject.put("idOrganisateur", organisateur.getIdparticipant());
				jsonObject.put("nomOrganisateur", organisateur.getNom());
				jsonObject.put("prenomOrganisateur", organisateur.getPrenom());


				jsonArray.add(jsonObject);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finalObject.put("rows", jsonArray);

		return finalObject;
	}
}
