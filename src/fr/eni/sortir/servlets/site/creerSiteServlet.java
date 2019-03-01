package fr.eni.sortir.servlets.site;

import fr.eni.sortir.bll.SiteManager;
import fr.eni.sortir.bo.Site;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/site/creer")
public class creerSiteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SiteManager siteManager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public creerSiteServlet() {
        super();
        this.siteManager = new SiteManager();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            Site nouveauSite = new Site();

            nouveauSite.setNom(request.getParameter("nom"));

            if (nouveauSite != null){
                siteManager.insert(nouveauSite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/gererSite.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerSite.jsp");
        rd.forward(request, response);
    }
}
