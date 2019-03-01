package fr.eni.sortir.servlets.site;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.SiteManager;
import fr.eni.sortir.bo.Site;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Servlet implementation class Site
 */
@WebServlet(
        urlPatterns= {
                "/site/creer",
                "/site/editer",
                "/site/supprimer"
        })
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

        if (request.getServletPath().equals("/site/creer"))
        {
            request.setAttribute("title", "Créer");
            request.setAttribute("path", "/site/creer");

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

            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "/site/gerer");
        }

        if (request.getServletPath().equals("/site/editer")){

            request.setCharacterEncoding("UTF-8");
            Site siteUpdated = new Site();

            siteUpdated.setIdSite(Integer.parseInt(request.getParameter("idSite")));
            siteUpdated.setNom(request.getParameter("nom"));

            SiteManager siteManager = new SiteManager();

            try {
                siteManager.update(siteUpdated);
            } catch (BusinessException | SQLException e)
            {
                e.printStackTrace();
            }
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "/site/gerer");
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getServletPath().equals("/site/creer"))
        {
            request.setAttribute("title", "Créer");
            request.setAttribute("path", "/site/creer");
            request.setAttribute("bouton", "Enregistrer");

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerSite.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/site/editer")) {

            request.setAttribute("title", "Modifier");
            request.setAttribute("path", "/site/editer");
            request.setAttribute("bouton", "Modifier");

            int idSite = Integer.parseInt(request.getParameter("idSite"));

            try {
                SiteManager siteManager = new SiteManager();
                Site site = siteManager.selectById(idSite);
                request.setAttribute("site", site);

            } catch (BusinessException | SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/creerSite.jsp");
            rd.forward(request, response);
        }

        if (request.getServletPath().equals("/site/supprimer"))
        {
            int idSite = Integer.parseInt(request.getParameter("idSite"));

            try {
                SiteManager siteManager = new SiteManager();
                siteManager.delete(idSite);
            } catch (BusinessException e)
            {
                e.printStackTrace();
            }

            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "/site/gerer");
        }
    }
}
