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
	
	public Participant selectById(int id) throws BusinessException, SQLException
	{
		return this.participantDAO.selectById(id);
	}
	
	public Participant ajouter(String nom, String prenom, String telephone, String email, boolean administrateur, boolean actif) throws BusinessException
	{
		BusinessException exception = new BusinessException();

		Participant participant = new Participant( nom, prenom, telephone, email, administrateur, actif);


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
	
	public Participant modifier(Participant participant) throws BusinessException, SQLException
	{
		return this.participantDAO.update(participant);
	}
	
	public void supprimer(int id) throws BusinessException
	{
		this.participantDAO.delete(id);
	}
}
