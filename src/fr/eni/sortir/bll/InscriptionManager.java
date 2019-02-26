package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.InscriptionDAO;


public class InscriptionManager {

    private InscriptionDAO inscriptionDAO;

    public InscriptionManager() {
        this.inscriptionDAO = DAOFactory.getInscriptionDAO();
    }

    public void inscriptionSortie(int idSortie, int idParticipant) throws BusinessException {
        if(verifSortieForInscriptionOrDesistement(idSortie)){
            this.inscriptionDAO.insert(idSortie, idParticipant);
        }
    }

    private boolean verifSortieForInscriptionOrDesistement(int idSortie) throws BusinessException {
        SortieManager sortieManager = new SortieManager();
        Sortie sortie = sortieManager.selectById(idSortie);
        return "Ouverte".equals(sortie.getEtat()) && sortie.getDateLimiteInscription().before(new java.sql.Date( new java.util.Date().getTime()));
    }

    public void desistementSortie(Integer idSortie, Integer idParticipant) throws BusinessException {
        if(verifSortieForInscriptionOrDesistement(idSortie)){
            this.inscriptionDAO.delete(idSortie, idParticipant);
        }
    }
}
