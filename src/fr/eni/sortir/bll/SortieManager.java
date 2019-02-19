package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.ListeSortieDAO;

import java.util.List;

public class SortieManager {
    private ListeSortieDAO listeSortieDAO;

    public SortieManager() {
        this.listeSortieDAO= DAOFactory.getListeSortieDAO();
    }

    public List<Sortie> selectionnerListes()
    {
        return this.listeSortieDAO.selectAll();
    }
}
