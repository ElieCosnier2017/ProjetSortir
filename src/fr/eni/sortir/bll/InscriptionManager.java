package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.InscriptionDAO;

import java.sql.Date;

public class InscriptionManager {

    private InscriptionDAO inscriptionDAO;

    public InscriptionManager() {
        this.inscriptionDAO = DAOFactory.getInscriptionDAO();
    }

    public void inscriptionSortie(int idSortie, int idParticipant) throws BusinessException {
        if(verifSortieForInscription(idSortie)){
            this.inscriptionDAO.insert(idSortie, idParticipant);
        }
    }

    private boolean verifSortieForInscription(int idSortie){
        SortieManager sortieManager = new SortieManager();
        Sortie sortie = sortieManager.selectById(idSortie);
        return "Ouverte".equals(sortie.getEtat()) && sortie.getDateLimiteInscription().before(new java.sql.Date( new java.util.Date().getTime()));
    }
}
