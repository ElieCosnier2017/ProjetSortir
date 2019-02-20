package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Sortie;

public class ListeSortieDAOJdbcImpl implements ListeSortieDAO {
	private static final String SELECT_ALL = "SELECT * FROM SORTIES";
	private static final String INSERT="INSERT INTO SORTIE (nom, datedebut, duree, datecloture, nbinscriptionsmax, descritpionsinfos, etatsortie, urlPhoto) VALUES (?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE SORTIE SET nom=?, datedebut=?, duree=?, datecloture=?, nbinscriptionsmax=?, descritpionsinfos=?, etatsortie=?, urlPhoto=? WHERE idSortie=?";
	private static final String DELETE="DELETE FROM SORTIE WHERE idSortie=?";

	@Override
	public List<Sortie> selectAll() {
		List<Sortie> listeSortie = new ArrayList<Sortie>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("libelle"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listeSortie;
	}
	
	/**
	 * Methode qui permet d'ajouter une sortie.
	 */
	@Override
	public void insert(Sortie sortie) throws BusinessException {
		if (sortie == null) 
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, sortie.getNom());
			pstmt.setDate(2, sortie.getDateDebut());
			pstmt.setInt(3, sortie.getDuree());
			pstmt.setDate(4, sortie.getDateLimiteInscription());
			pstmt.setInt(5, sortie.getNbInscriptionsMax());
			pstmt.setString(6, sortie.getInfosSortie());
			pstmt.setString(7, sortie.getEtat());
			pstmt.setString(8, sortie.getPhoto());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next())
			{
				sortie.setIdSortie(rs.getInt(1));
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
	 * Methode qui permet de modifier un participant.
	 */
	@Override
	public Sortie update(Sortie sortie) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			pstmt.setString(1, sortie.getNom());
			pstmt.setDate(2, sortie.getDateDebut());
			pstmt.setInt(3, sortie.getDuree());
			pstmt.setDate(4, sortie.getDateLimiteInscription());
			pstmt.setInt(5, sortie.getNbInscriptionsMax());
			pstmt.setString(6, sortie.getInfosSortie());
			pstmt.setString(7, sortie.getEtat());
			pstmt.setString(8, sortie.getPhoto());
			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			throw new SQLException(e);
		}
		return sortie;
	}
	
	/**
	 * Methode qui permet de supprimer une sortie.
	 */
	@Override
	public void delete(int idSortie) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, idSortie);
			pstmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
