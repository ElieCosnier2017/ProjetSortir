package fr.eni.sortir.servlets.ville;

import fr.eni.sortir.bll.*;
import fr.eni.sortir.bo.Ville;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ville/gerer")
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

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        out.println(json_ville().toJSONString());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/gererVille.jsp");
        rd.forward(request, response);
    }

    private JSONObject json_ville(){
        JSONArray jsonArray = new JSONArray();
        JSONObject finalObject = new JSONObject();

        try {
            List<Ville> listVille = villeManager.selectAll();
            for (Ville ville: listVille) {
                JSONObject jsonObject = new JSONObject();
                System.out.println(ville.toString());
                jsonObject.put("no_ville", ville.getIdVille());
                jsonObject.put("nom", ville.getNom());
                jsonObject.put("codepostal", ville.getCodePostal());

                jsonArray.add(jsonObject);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        finalObject.put("rows", jsonArray);

        return finalObject;
    }
}
