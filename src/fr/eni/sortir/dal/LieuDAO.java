package fr.eni.sortir.dal;

import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Lieu;

public interface LieuDAO {
	public List<Lieu> selectAll() throws BusinessException;
}
