package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VilleDAOJdbcImpl implements  VilleDAO {

    private static final String SELECT_ALL="SELECT * FROM VILLES";

    /**
     * Méthode qui sélectionne tous les éléments de la table LIEUX
     */
    @Override
    public List<Ville> selectAll() throws BusinessException {
        List<Ville> villes = new ArrayList<Ville>();

        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                villes.add(this.map(rs));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return villes;
    }

    /**
     * @param rs
     * @return ville
     * @throws SQLException
     */
    private Ville map(ResultSet rs) throws SQLException {
        Ville ville = new Ville();
        ville.setIdVille(rs.getInt("no_ville"));
        ville.setNom(rs.getString("nom_ville"));
        ville.setCodePostal(rs.getInt("code_postal"));
        return ville;
    }
}
