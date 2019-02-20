package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bo.Sortie;
import org.json.simple.JSONArray;

public class ListeSortieDAOJdbcImpl implements ListeSortieDAO {
	private static final String SELECT_ALL = "SELECT * FROM SORTIES";
	private static final String SELECT_SORTIE_BY_SITE = "SELECT s.* FROM SORTIES As s JOIN " +
			" PARTICIPANTS AS p ON s.organisateur = p.no_participant WHERE p.sites_no_site = ?";

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

	@Override
	public JSONArray selectSortiesBySite(int idSite) {
		List<Sortie> listeSortie = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_SORTIE_BY_SITE);
			pstmt.setInt(1, idSite);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Sortie sortie = sortieBuilder(rs);
				listeSortie.add(sortie);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(listeSortie);
		System.out.println(jsonArray.toJSONString());
		return jsonArray;
	}

	/**
	 *
	 * @param rs rs
	 * @return sortie
	 * @throws SQLException SQLException
	 */
	public Sortie  sortieBuilder(ResultSet rs) throws SQLException {
		Sortie sortie = new Sortie();
		sortie.setIdSortie(rs.getInt("no_sortie"));
		sortie.setDateHeureDebut(rs.getDate("datedebut"));
		sortie.setDuree(rs.getInt("duree"));
		sortie.setDateLimiteInscription(rs.getDate("datecloture"));
		sortie.setNbInscriptionsMax(rs.getInt("nbinscriptionsmax"));
		sortie.setInfosSortie(rs.getString("descriptioninfos"));
		sortie.setEtat(rs.getString("etatsortie"));
		return sortie;
	}
}
