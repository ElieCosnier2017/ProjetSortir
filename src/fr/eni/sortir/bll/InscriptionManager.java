package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.InscriptionDAO;

public class InscriptionManager {

    private InscriptionDAO inscriptionDAO;
    private SortieManager sortieManager;

    public InscriptionManager() {
        this.inscriptionDAO = DAOFactory.getInscriptionDAO();
        sortieManager = new SortieManager();
    }

    public void inscriptionSortie(int idSortie, int idParticipant) throws BusinessException {
        if (verifSortieForInscriptionOrDesistement(idSortie) && verifSortieNbInscriptionMax(idSortie)) {
            this.inscriptionDAO.insert(idSortie, idParticipant);
        }
    }

    public void desistementSortie(Integer idSortie, Integer idParticipant) throws BusinessException {
        if (verifSortieForInscriptionOrDesistement(idSortie)) {
            this.inscriptionDAO.delete(idSortie, idParticipant);
        }
    }

    private boolean verifSortieForInscriptionOrDesistement(int idSortie) throws BusinessException {
        Sortie sortie = sortieManager.selectById(idSortie);
        return 1 == sortie.getIdEtat() && sortie.getDateLimiteInscription().after(new java.sql.Date(new java.util.Date().getTime()));
    }

    private boolean verifSortieNbInscriptionMax(int idSortie) throws BusinessException {
        int nbInscription = inscriptionDAO.count(idSortie);
        Sortie sortie = sortieManager.selectById(idSortie);
        return nbInscription < sortie.getNbInscriptionsMax();
    }
}
