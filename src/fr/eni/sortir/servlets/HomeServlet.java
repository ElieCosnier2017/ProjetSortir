package fr.eni.sortir.servlets;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.ConnexionManager;
import fr.eni.sortir.bll.SiteManager;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Site;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;


public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SiteManager siteManager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        this.siteManager = new SiteManager();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Site> sites = null;
        try {
            sites = siteManager.selectAll();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        Date aujourdhui = new Date();
        DateFormat shortDateFormat = DateFormat.getDateInstance(
                DateFormat.SHORT);
        request.setAttribute("date", shortDateFormat.format(aujourdhui));
        request.setAttribute("listeSite", sites);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/accueil.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}