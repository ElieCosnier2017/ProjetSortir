package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Etat;

import java.sql.SQLException;
import java.util.List;

public interface EtatDAO {
    List<Etat> selectAll() throws BusinessException;
    Etat selectById(int idEtat) throws SQLException;
}
