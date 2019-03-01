package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiteDAOJdbcImpl implements SiteDAO {

    private static final String SELECT_ALL="SELECT * FROM SITES";
    private static final String SELECT_ONE_BY_ID = "SELECT nom_site FROM SITES WHERE no_site=?";
    private static final String INSERT = "INSERT INTO SITES (nom_site) VALUES (?)";


    /**
     * Méthode qui sélectionne tous les éléments de la table LIEUX
     */
    @Override
    public List<Site> selectAll() throws BusinessException {
        List<Site> sites = new ArrayList<Site>();

        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                sites.add(this.siteBuilder(rs));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return sites;
    }

    /**
     * Méthode qui récupère tous les éléments de la table SITES pour un ID donné
     */
    @Override
    public Site selectById(int idSite) throws SQLException {
        Site site = null;

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_ID);

            pstmt.setInt(1, idSite);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                site = new Site(idSite);
                site.setNom(rs.getString("nom_site"));
            }
        } catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return site;
    }

    /**
     * Méthode qui permet d'ajouter un site à la table SITES
     */
    @Override
    public void insert(Site site) throws BusinessException {
        if (site == null)
        {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, site.getNom());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next())
            {
                site.setIdSite(rs.getInt(1));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }
    }

    /**
     * @param rs
     * @return ville
     * @throws SQLException
     */
    private Site siteBuilder(ResultSet rs) throws SQLException {
        Site site = new Site();
        site.setIdSite(rs.getInt("no_site"));
        site.setNom(rs.getString("nom_site"));
        return site;
    }
}
