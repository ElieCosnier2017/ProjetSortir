package fr.eni.sortir.servlets.sortie;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.InscriptionManager;
import fr.eni.sortir.dal.CodesResultatDAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        urlPatterns= {
                "/sortie/inscription",
                "/sortie/desistement"
        })
public class InscriptionSortieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idSortie = lireParametreIdSortie(request);
        HttpSession session = request.getSession();
        Integer idParticipant = (Integer) session.getAttribute("idParticipant");
        InscriptionManager inscriptionManager = new InscriptionManager();
        if(request.getServletPath().equals("/sortie/inscription")){
            try {
                inscriptionManager.inscriptionSortie(idSortie, idParticipant);
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "/");
            } catch (BusinessException e) {
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "/");
                e.ajouterErreur(CodesResultatDAL.ALREADY_EXIST);
                e.printStackTrace();
            }
        }
        else {
            try {
                inscriptionManager.desistementSortie(idSortie, idParticipant);
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "/");
            } catch (BusinessException e) {
                response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "/");
                e.printStackTrace();
            }
        }
    }

    private int lireParametreIdSortie(HttpServletRequest request) {
        Integer idSortie = null;
        if(request.getParameter("id")!=null) {
            idSortie = Integer.parseInt(request.getParameter("id"));
        }
        return idSortie;
    }
}
