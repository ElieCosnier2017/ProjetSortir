package fr.eni.sortir.dal;

import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Sortie;

public interface ListeSortieDAO {
	public List<Sortie> selectAll() throws BusinessException;
}
