package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Ville;

import java.sql.SQLException;
import java.util.List;

public interface VilleDAO {
    List<Ville> selectAll() throws BusinessException;

    Ville selectOneById(int idVille) throws BusinessException;

    void insert(Ville ville) throws BusinessException;

    Ville update(Ville ville) throws SQLException;

    void delete(int idVille) throws BusinessException;
}
