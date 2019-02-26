package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Etat;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.EtatDAO;

import java.sql.SQLException;
import java.util.List;

public class EtatManager {

    private EtatDAO etatDAO;
    public EtatManager() {
        this.etatDAO= DAOFactory.getEtatDAO();
    }

    public List<Etat> selectAll() throws BusinessException
    {
        return this.etatDAO.selectAll();
    }

    public Etat selectById(int idEtat) throws BusinessException, SQLException
    {
        return this.etatDAO.selectById(idEtat);
    }

    public Etat selectByLibelle(String libelle){
        return this.etatDAO.selectByLibelle(libelle);
    }
}
