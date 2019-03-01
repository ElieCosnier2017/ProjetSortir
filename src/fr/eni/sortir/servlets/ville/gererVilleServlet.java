package fr.eni.sortir.servlets.ville;

import fr.eni.sortir.bll.*;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.bo.Ville;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ville/gererVille")
public class gererVilleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VilleManager villeManager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gererVilleServlet() {
        super();
        this.villeManager = new VilleManager();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        try{
            List<Ville> villes = villeManager.selectAll();
            request.setAttribute("villes", villes);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/gererVille.jsp");
        rd.forward(request, response);
    }
}
