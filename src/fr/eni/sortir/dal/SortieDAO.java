package fr.eni.sortir.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Sortie;
import org.json.simple.JSONArray;

public interface SortieDAO {
	List<Sortie> selectAll() throws BusinessException;
	JSONArray selectSortiesBySite(int idSite);

	void insert(Sortie sortie) throws BusinessException;

	Sortie update(Sortie sortie) throws SQLException;

	void delete(int idSortie) throws BusinessException;

	Sortie selectById(int idSortie);

	List selectAllInfoById(int idSortie);

    void cancelSortie(int idSortie, String motif);
}
