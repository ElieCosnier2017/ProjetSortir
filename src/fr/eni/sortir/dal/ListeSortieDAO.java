package fr.eni.sortir.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Participant;
import fr.eni.sortir.bo.Sortie;

public interface ListeSortieDAO {
	public List<Sortie> selectAll() throws BusinessException;

	void insert(Sortie sortie) throws BusinessException;
	
	Sortie update(Sortie sortie) throws SQLException;
	
	void delete(int idSortie) throws BusinessException;
}
