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
    private static final String SELECT_ONE_BY_ID = "SELECT * FROM VILLES WHERE no_ville=?";
    private static final String INSERT = "INSERT INTO VILLES(nom_ville, code_postal) VALUES (?,?)";
    private static final String UPDATE = "UPDATE VILLES SET nom_ville=?, code_postal=? WHERE no_ville=?";
    private static final String DELETE = "DELETE FROM VILLES WHERE no_ville=?";

    /**
     * Méthode qui permet de modifier une ville existant dans la table VILLES
     */
    @Override
    public Ville update(Ville ville) throws SQLException {
        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
            pstmt.setString(1, ville.getNom());
            pstmt.setInt(2, ville.getCodePostal());
            pstmt.setInt(3, ville.getIdVille());
            pstmt.executeUpdate();

        } catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return ville;
    }


    /**
     * Méthode qui permet de supprimer un élément de la table VILLES
     */
    @Override
    public void delete(int idVille) throws BusinessException {
        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE);
            pstmt.setInt(1, idVille);
            pstmt.executeUpdate();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui permet d'ajouter une ville à la table VILLES
     */
    @Override
    public void insert(Ville ville) throws BusinessException {
        if (ville == null)
        {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, ville.getNom());
            pstmt.setString(2, String.valueOf(ville.getCodePostal()));
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next())
            {
                ville.setIdVille(rs.getInt(1));
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
     * Méthode qui récupère tous les éléments de la table VILLES pour un ID donné
     */
    @Override
    public Ville selectOneById(int idVille) throws BusinessException {
        Ville ville = null;

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_ID);

            pstmt.setInt(1, idVille);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next())
            {
                ville = this.map(rs);
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
    private Ville map(ResultSet rs) throws SQLException {
        Ville ville = new Ville();
        ville.setIdVille(rs.getInt("no_ville"));
        ville.setNom(rs.getString("nom_ville"));
        ville.setCodePostal(rs.getInt("code_postal"));
        return ville;
    }
}
