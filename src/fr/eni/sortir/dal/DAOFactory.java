package fr.eni.sortir.dal;

public abstract class DAOFactory {
	
	public static listeSortieDAO getListeSortieDAO()
	{
		return new ListeSortieDAOJdbcImpl();
	}
}
	