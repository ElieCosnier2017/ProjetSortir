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
    private static final String SELECT_ONE_BY_ID = "SELECT * FROM VILLES WHERE idVille=?";

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
                villes.add(this.villeBuilder(rs));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return villes;
    }

    /**
     * Méthode qui récupère tous les éléments de la table VILLES pour un ID donné
     */
    @Override
    public Ville selectOneById(int idVille) throws BusinessException {
        Ville ville = new Ville();

        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_ID);
            pstmt.setInt(1, idVille);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next())
            {
                ville = this.villeBuilder(rs);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return ville;
    }

    /**
     * @param rs
     * @return ville
     * @throws SQLException
     */
    private Ville villeBuilder(ResultSet rs) throws SQLException {
        Ville ville = new Ville();
        ville.setIdVille(rs.getInt("no_ville"));
        ville.setNom(rs.getString("nom_ville"));
        ville.setCodePostal(rs.getInt("code_postal"));
        return ville;
    }
}
