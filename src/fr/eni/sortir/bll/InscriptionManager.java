package fr.eni.sortir.bll;

import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.InscriptionDAO;

public class InscriptionManager {

    private InscriptionDAO inscriptionDAO;

    public InscriptionManager() {
        this.inscriptionDAO = DAOFactory.getInscriptionDAO();
    }

    public void inscriptionSortie(int idSortie, int idParticipant) throws BusinessException {
        this.inscriptionDAO.insert(idSortie, idParticipant);
    }
}
