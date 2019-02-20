package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.ListeSortieDAO;

import java.sql.Date;
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
    
    public Sortie ajouter(String nom, Date dateDebut, int duree, Date dateFin, int nbInscriptions, String infos, String etat, String photo, String organistaeur, int idLieu, int idEtat) throws BusinessException
	{
		BusinessException exception = new BusinessException();

		Sortie sortie = new Sortie( nom, dateDebut, duree, dateFin, nbInscriptions, infos, etat, photo);


		if(!exception.hasErreurs())
		{
			this.listeSortieDAO.insert(sortie);
		}

		if(exception.hasErreurs())
		{
			throw exception;
		}
		return sortie;
	}
}
