package fr.eni.sortir.servlets.sortie;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bll.InscriptionManager;
import fr.eni.sortir.bo.Participant;

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
        if(request.getServletPath().equals("/sortir/inscription")){
            try {
                inscriptionManager.inscriptionSortie(idSortie, idParticipant);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                inscriptionManager.desistementSortie(idSortie, idParticipant);
            } catch (BusinessException e) {
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
