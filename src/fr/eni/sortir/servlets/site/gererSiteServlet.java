package fr.eni.sortir.servlets.site;

import fr.eni.sortir.bll.*;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Site;
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

@WebServlet("/site/gerer")
public class gererSiteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SiteManager siteManager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gererSiteServlet() {
        super();
        this.siteManager = new SiteManager();
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

        out.println(json_site().toJSONString());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/gererSite.jsp");
        rd.forward(request, response);
    }

    private JSONObject json_site(){
        JSONArray jsonArray = new JSONArray();
        JSONObject finalObject = new JSONObject();

        try {
            List<Site> listSite = siteManager.selectAll();
            for (Site site: listSite) {
                JSONObject jsonObject = new JSONObject();
                System.out.println(site.toString());
                jsonObject.put("no_site", site.getIdSite());
                jsonObject.put("nom", site.getNom());

                jsonArray.add(jsonObject);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        finalObject.put("rows", jsonArray);

        return finalObject;
    }
}
