package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Ville;

import java.util.List;

public interface VilleDAO {
    List<Ville> selectAll() throws BusinessException;
    Ville selectOneById(int idVille) throws BusinessException;
    void insert(Ville ville) throws BusinessException;
}
