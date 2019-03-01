package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Etat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtatDAOJdbcImpl implements  EtatDAO {

    private static final String SELECT_ALL="SELECT * FROM ETATS";
    private static final String SELECT_ONE_BY_ID = "SELECT * FROM ETATS WHERE no_etat=?";
    private static final String SELECT_ONE_BY_LIBELLE = "SELECT * FROM ETATS WHERE libelle=?";


    /**
     * Méthode qui sélectionne tous les éléments de la table LIEUX
     */
    @Override
    public List<Etat> selectAll() throws BusinessException {
        List<Etat> etats = new ArrayList<Etat>();

        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                etats.add(this.map(rs));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return etats;
    }

    /**
     * Méthode qui récupère tous les éléments de la table ETATS pour un ID donné
     */
    @Override
    public Etat selectById(int idEtat) {
        Etat etat = null;

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_ID);

            pstmt.setInt(1, idEtat);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next())
            {
                etat = this.map(rs);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return etat;
    }

    /**
     * Méthode qui récupère tous les éléments de la table ETATS pour un Libelle donné
     */
    @Override
    public Etat selectByLibelle(String libelleEtat) {
        Etat etat = new Etat();

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_LIBELLE);

            pstmt.setString(1, libelleEtat);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next())
            {
                etat.setIdEtat(rs.getInt("no_etat"));
                etat.setLibelle(rs.getString("libelle"));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return etat;
    }

    /**
     * @param rs
     * @return lieu
     * @throws SQLException
     */
    private Etat map(ResultSet rs) throws SQLException {
        Etat etat = new Etat();
        etat.setIdEtat(rs.getInt("no_etat"));
        etat.setLibelle(rs.getString("libelle"));
        return etat;
    }
}
