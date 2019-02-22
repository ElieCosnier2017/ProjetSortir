package fr.eni.sortir.bll;

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

    public Sortie ajouter(String nom, Date dateDebut, int duree, Date dateFin, int nbInscriptions, String infos, String etat, String photo, String organistaeur, int idLieu, int idEtat) throws BusinessException
	{
		BusinessException exception = new BusinessException();

		Sortie sortie = new Sortie( nom, dateDebut, duree, dateFin, nbInscriptions, infos, etat, photo);


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


}
