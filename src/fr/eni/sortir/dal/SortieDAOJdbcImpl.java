package fr.eni.sortir.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Lieu;
import fr.eni.sortir.bo.Site;
import fr.eni.sortir.bo.Sortie;
import fr.eni.sortir.bo.Ville;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SortieDAOJdbcImpl implements SortieDAO {
	private static final String SELECT_ALL = "SELECT * FROM SORTIES";
    private static final String SELECT_BY_ID = "SELECT * FROM SORTIES WHERE no_sortie=?";
	private static final String SELECT_ALL_INFO_BY_ID = "SELECT * FROM SORTIES As s " +
			"JOIN PARTICIPANTS AS p ON s.organisateur = p.no_participant " +
			"JOIN LIEUX as l ON s.lieux_no_lieu = l.no_lieu " +
			"JOIN VILLES as v ON l.villes_no_ville = v.no_ville " +
			"JOIN SITES as si ON p.sites_no_site = si.no_site " +
			"WHERE s.no_sortie = ?";
	private static final String INSERT="INSERT INTO SORTIES (nom, datedebut, duree, datecloture, nbinscriptionsmax, descriptioninfos, etatsortie, urlPhoto, organisateur, lieux_no_lieu, etats_no_etat) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE SORTIES SET nom=?, datedebut=?, duree=?, datecloture=?, nbinscriptionsmax=?, descriptioninfos=?, organisateur=?, lieux_no_lieu=?, etats_no_etat=? WHERE no_sortie=?";
	private static final String DELETE="DELETE FROM SORTIES WHERE idSortie=?";
	private static final String SELECT_SORTIE_BY_SITE = "SELECT s.* FROM SORTIES As s JOIN " +
			" PARTICIPANTS AS p ON s.organisateur = p.no_participant WHERE p.sites_no_site = ?" +
			" ORDER BY s.datecloture DESC ";
	private static final String CANCEL_SORTIE = "UPDATE SORTIES SET etatsortie=?, etats_no_etat=? WHERE no_sortie=?";
	private static final String POST_SORTIE = "UPDATE SORTIES SET etats_no_etat=? WHERE no_sortie=?";

	@Override
	public List<Sortie> selectAll() {
		List<Sortie> listeSortie = new ArrayList<Sortie>();
//		try(Connection cnx = ConnectionProvider.getConnection()) {
//			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
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
			pstmt.setTimestamp(2, new Timestamp(sortie.getDateDebut().getTime()));
			pstmt.setInt(3, sortie.getDuree());
			pstmt.setTimestamp(4, new Timestamp(sortie.getDateLimiteInscription().getTime()));
			pstmt.setInt(5, sortie.getNbInscriptionsMax());
			pstmt.setString(6, sortie.getInfosSortie());
			pstmt.setString(7, sortie.getEtat());
			pstmt.setString(8, sortie.getPhoto());
			pstmt.setInt(9, sortie.getOrganisateur());
			pstmt.setInt(10, sortie.getIdLieu());
			pstmt.setInt(11, sortie.getIdEtat());

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
			pstmt.setTimestamp(2, new Timestamp(sortie.getDateDebut().getTime()));
			pstmt.setInt(3, sortie.getDuree());
			pstmt.setTimestamp(4, new Timestamp(sortie.getDateLimiteInscription().getTime()));
			pstmt.setInt(5, sortie.getNbInscriptionsMax());
			pstmt.setString(6, sortie.getInfosSortie());
			pstmt.setInt(7, sortie.getOrganisateur());
			pstmt.setInt(8, sortie.getIdLieu());
			pstmt.setInt(9, sortie.getIdEtat());
			pstmt.setInt(10, sortie.getIdSortie());
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

	@Override
	public Sortie selectById(int idSortie) {
        Sortie sortie = new Sortie();
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, idSortie);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
               sortie = sortieBuilder(rs);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sortie;
	}

	@Override
	public List selectAllInfoById(int idSortie) {
		Sortie sortie = new Sortie();
		Lieu lieu = new Lieu();
		Ville ville = new Ville();
		Site site = new Site();
		List sortieInfo = new ArrayList();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_INFO_BY_ID);
			pstmt.setInt(1, idSortie);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				sortie = sortieBuilder(rs);
				lieu.setIdLieu(rs.getInt("no_lieu"));
				lieu.setLatitude(rs.getFloat("latitude"));
				lieu.setLongitude(rs.getFloat("longitude"));
				lieu.setNom(rs.getString("nom_lieu"));
				lieu.setRue(rs.getString("rue"));
				ville.setIdVille(rs.getInt("no_ville"));
				ville.setCodePostal(rs.getInt("code_postal"));
				ville.setNom(rs.getString("nom_ville"));
				site.setIdSite(rs.getInt("no_site"));
				site.setNom(rs.getString("nom_site"));
				sortieInfo.add(sortie);
				sortieInfo.add(lieu);
				sortieInfo.add(ville);
				sortieInfo.add(site);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sortieInfo;
	}

	@Override
	public void cancelSortie(int idSortie, String motif) {
		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(CANCEL_SORTIE);

			pstmt.setString(1, motif);
			pstmt.setInt(2, 6);
			pstmt.setInt(3, idSortie);

			pstmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void postSortie(int idSortie, int idEtat) {
		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(POST_SORTIE);

			pstmt.setInt(1, idEtat);
			pstmt.setInt(2, idSortie);

			pstmt.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public List<Sortie> selectSortiesBySite(int idSite) {
		List listSortie = new ArrayList();

		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_SORTIE_BY_SITE);
			pstmt.setInt(1, idSite);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Sortie sortie = sortieBuilder(rs);
				listSortie.add(sortie);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listSortie;
	}

	/**
	 *
	 * @param rs rs
	 * @return sortie
	 * @throws SQLException SQLException
	 */
	public Sortie sortieBuilder(ResultSet rs) throws SQLException {
		Sortie sortie = new Sortie();

		sortie.setIdSortie(rs.getInt("no_sortie"));
		sortie.setNom(rs.getString("nom"));
		sortie.setDateDebut(rs.getDate("datedebut"));
		sortie.setDuree(rs.getInt("duree"));
		sortie.setDateLimiteInscription(rs.getDate("datecloture"));
		sortie.setNbInscriptionsMax(rs.getInt("nbinscriptionsmax"));
		sortie.setInfosSortie(rs.getString("descriptioninfos"));
		sortie.setEtat(rs.getString("etatsortie"));
		sortie.setPhoto(rs.getString("urlPhoto"));
		sortie.setidEtat(rs.getInt("etats_no_etat"));
		sortie.setIdLieu(rs.getInt("lieux_no_lieu"));
		sortie.setOrganisateur(rs.getInt("organisateur"));
		return sortie;
	}
}
