package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Etat;
import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.SortieDAO;
import org.json.simple.JSONArray;

import java.sql.Date;
import java.util.List;

public class SortieManager {
    private SortieDAO sortieDAO;

    public SortieManager() {
        this.sortieDAO = DAOFactory.getSortieDAO();
    }

    public List<Sortie> selectionnerListes() throws BusinessException {
        return this.sortieDAO.selectAll();
    }

    public Sortie ajouter(Sortie sortie) throws BusinessException
	{
		BusinessException exception = new BusinessException();

		if(!exception.hasErreurs())
		{
			this.sortieDAO.insert(sortie);
		}

		if(exception.hasErreurs())
		{
			throw exception;
		}
		return sortie;
	}

    public JSONArray sortiesBySite(int idSite) throws BusinessException
    {
        return this.sortieDAO.selectSortiesBySite(idSite);
    }

    public Sortie selectById(int idSortie){
        return this.sortieDAO.selectById(idSortie);
    }

    public List selectAllInfoById(int idSortie){
        return this.sortieDAO.selectAllInfoById(idSortie);
    }

    public void cancelSortie(int idSortie, String motif) {
        EtatManager etatManager = new EtatManager();
        Etat etat = etatManager.selectByLibelle("Annulée");
        this.sortieDAO.cancelSortie(idSortie, etat.getIdEtat(), motif);
    }

}
