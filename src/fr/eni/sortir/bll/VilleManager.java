package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Ville;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.VilleDAO;

import java.sql.SQLException;
import java.util.List;

public class VilleManager {
    private VilleDAO villeDAO;
    public VilleManager() {
        this.villeDAO= DAOFactory.getVilleDAO();
    }

    public List<Ville> selectAll() throws BusinessException
    {
        return this.villeDAO.selectAll();
    }

    public Ville selectById(int idVille) throws BusinessException, SQLException
    {
        return this.villeDAO.selectOneById(idVille);
    }

    public void ajouter(Ville ville) throws BusinessException
    {
        BusinessException exception = new BusinessException();

        if(!exception.hasErreurs())
        {
            this.villeDAO.insert(ville);
        }

        if(exception.hasErreurs())
        {
            throw exception;
        }
    }

    public void delete(int id) throws SQLException, BusinessException
    {
        this.villeDAO.delete(id);
    }

    public Ville update(Ville ville) throws BusinessException, SQLException
    {
        return this.villeDAO.update(ville);
    }
}
