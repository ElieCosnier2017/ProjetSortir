package fr.eni.sortir.dal;

import fr.eni.sortir.bo.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteDAOJdbcImpl implements SiteDAO {

    private static final String SELECT_ONE_BY_ID = "SELECT nom_site FROM SITES WHERE no_site=?";

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
}
