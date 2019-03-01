package fr.eni.sortir.bll;

import fr.eni.sortir.bo.Site;
import fr.eni.sortir.dal.DAOFactory;
import fr.eni.sortir.dal.SiteDAO;

import java.sql.SQLException;
import java.util.List;

public class SiteManager {
    private SiteDAO siteDAO;

    public SiteManager()
    {
        this.siteDAO= DAOFactory.getSiteDAO();
    }

    public List<Site> selectAll() throws BusinessException
    {
        return this.siteDAO.selectAll();
    }

    public Site selectById(int idSite) throws BusinessException, SQLException
    {
        return this.siteDAO.selectById(idSite);
    }

    public void insert(Site siteNew) throws BusinessException
    {
        this.siteDAO.insert(siteNew);
    }

    public Site update(Site site) throws BusinessException, SQLException
    {
        return this.siteDAO.update(site);
    }

    public void delete(int id) throws BusinessException
    {
        this.siteDAO.delete(id);
    }
}
