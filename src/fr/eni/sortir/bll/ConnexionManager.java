package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.ParticipantDAO;

public class ConnexionManager {
    private ParticipantDAO participantDAO;

    public ConnexionManager() {
        this.participantDAO= DAOFactory.getParticipantDAO();
    }

    public Participant getParticipant(String email, String mdp) throws BusinessException {
        return this.participantDAO.selectByEmailAndPassword(email, mdp);
    }
}

