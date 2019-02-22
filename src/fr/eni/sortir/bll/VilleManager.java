package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Ville;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.VilleDAO;

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
}
