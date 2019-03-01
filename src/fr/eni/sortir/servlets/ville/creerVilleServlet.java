package fr.eni.sortir.servlets.ville;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.VilleManager;
import fr.eni.sortir.bo.Ville;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class Ville
 */
@WebServlet(
        urlPatterns= {
                "/ville/creer",
                "/ville/editer",
                "/ville/supprimer"
        })
public class creerVilleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VilleManager villeManager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerVilleServlet() {
        super();
        this.villeManager = new VilleManager();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getServletPath().equals("/ville/creer"))
        {
            request.setAttribute("title", "Créer");
            request.setAttribute("path", "/ville/creer");

            try {
                request.setCharacterEncoding("UTF-8");
                Ville nouvelleVille = new Ville();

                nouvelleVille.setNom(request.getParameter("nom"));
                nouvelleVille.setCodePostal(Integer.parseInt(request.getParameter("cp")));

                if (nouvelleVille != null){
                    villeManager.ajouter(nouvelleVille);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "/ville/gerer");
        }

        if (request.getServletPath().equals("/ville/editer")){

            request.setCharacterEncoding("UTF-8");
            Ville villeUpdated = new Ville();

            villeUpdated.setIdVille(Integer.parseInt(request.getParameter("idVille")));
            villeUpdated.setNom(request.getParameter("nom"));
            villeUpdated.setCodePostal(Integer.parseInt(request.getParameter("cp")));

            VilleManager villeManager = new VilleManager();

            try {
                villeManager.update(villeUpdated);
            } catch (BusinessException | SQLException e)
            {
                e.printStackTrace();
            }

            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "/ville/gerer");
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/ville/creer"))
        {
            request.setAttribute("title", "Créer");
            request.setAttribute("path", "/ville/creer");
            request.setAttribute("bouton", "Enregistrer");

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerVille.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/ville/editer")) {

            request.setAttribute("title", "Modifier");
            request.setAttribute("path", "/ville/editer");
            request.setAttribute("bouton", "Modifier");

            int idVille = Integer.parseInt(request.getParameter("idVille"));

            try {
                VilleManager villeManager = new VilleManager();
                Ville ville = villeManager.selectById(idVille);
                request.setAttribute("ville", ville);
            } catch (BusinessException | SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerVille.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/ville/supprimer"))
        {
            int idVille = Integer.parseInt(request.getParameter("idVille"));

            try {
                VilleManager villeManager = new VilleManager();
                villeManager.delete(idVille);
            } catch (BusinessException e)
            {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "/ville/gerer");
        }
    }
}
