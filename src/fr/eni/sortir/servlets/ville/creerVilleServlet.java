package fr.eni.sortir.servlets.ville;

import fr.eni.sortir.bll.VilleManager;
import fr.eni.sortir.bo.Ville;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ville/creer")
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

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/gererVille.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerVille.jsp");
        rd.forward(request, response);
    }
}
