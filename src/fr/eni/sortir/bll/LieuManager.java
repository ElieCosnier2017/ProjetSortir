package fr.eni.sortir.bll;

import java.util.List;

import fr.eni.sortir.bo.Lieu;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.LieuDAO;

public class LieuManager {
private LieuDAO lieuDAO;
	
	public LieuManager() 
	{
		this.lieuDAO=DAOFactory.getLieuDAO();
	}
	
	public List<Lieu> selectAll() throws BusinessException
	{
		return this.lieuDAO.selectAll();
	}
}
