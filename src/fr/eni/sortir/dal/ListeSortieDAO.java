package fr.eni.sortir.dal;

import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Sortie;
import org.json.simple.JSONArray;

public interface ListeSortieDAO {
	public List<Sortie> selectAll() throws BusinessException;
	public JSONArray selectSortiesBySite(int idSite);
}
