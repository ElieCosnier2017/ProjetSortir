package fr.eni.sortir.dal;

public abstract class DAOFactory {
	
	public static ListeSortieDAO getListeSortieDAO()
	{
		return new ListeSortieDAOJdbcImpl();
	}
	
	 public static ParticipantDAO getParticipantDAO()
	{
		return new ParticipantDAOJdbcImpl();
	}
}
	