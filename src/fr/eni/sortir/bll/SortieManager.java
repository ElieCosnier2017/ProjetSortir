package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.ListeSortieDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class SortieManager {
    private ListeSortieDAO listeSortieDAO;

    public SortieManager() {
        this.listeSortieDAO= DAOFactory.getListeSortieDAO();
    }

    public List<Sortie> selectionnerListes() throws BusinessException
    {
        return this.listeSortieDAO.selectAll();
    }

    public JSONArray sortiesBySite(int idSite) throws BusinessException
    {
        return this.listeSortieDAO.selectSortiesBySite(idSite);
    }
}
