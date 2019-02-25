package fr.eni.sortir.bll;

import java.sql.SQLException;

import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.ParticipantDAO;

public class ParticipantManager {
	private ParticipantDAO participantDAO;
	
	public ParticipantManager() 
	{
		this.participantDAO=DAOFactory.getParticipantDAO();
	}

	public Participant afficher(int no_participant) throws BusinessException, SQLException {
		BusinessException exception = new BusinessException();

		Participant participant = null;
		if(!exception.hasErreurs()) {
			 participant = this.participantDAO.selectById(no_participant);
		}

		return participant;
	}


	public Participant ajouter(String nom, String prenom, String telephone, String mail, String pseudo, String password, boolean admin, boolean actif) throws BusinessException{
		BusinessException exception = new BusinessException();

		Participant participant = new Participant(nom, prenom, telephone, mail, pseudo, password, admin, actif);


		if(!exception.hasErreurs())
		{
			this.participantDAO.insert(participant);
		}

		if(exception.hasErreurs())
		{
			throw exception;
		}
		return participant;
	}
	
	public Participant modifier(Participant participant) throws BusinessException, SQLException{
		return this.participantDAO.update(participant);
	}
	
	public void supprimer(int id) throws BusinessException
	{
		this.participantDAO.delete(id);
	}
}
