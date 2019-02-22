package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Lieu;

public class LieuDAOJdbcImpl implements LieuDAO{
	private static final String SELECT_ALL = "SELECT * FROM LIEUX";

	/**
	 * Méthode qui sélectionne tous les éléments de la table LIEUX
	 */
	@Override
	public List<Lieu> selectAll() throws BusinessException {
		List<Lieu> listeLieux = new ArrayList<Lieu>();

		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next())
			{
				listeLieux.add(this.map(rs));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return listeLieux;
	}

	/**
	 * @param rs
	 * @return lieu
	 * @throws SQLException
	 */
	private Lieu map(ResultSet rs) throws SQLException {
		Lieu lieu = new Lieu();
		lieu.setIdLieu(rs.getInt("no_lieu"));
		lieu.setNom(rs.getString("nom_lieu"));
		lieu.setRue(rs.getString("rue"));
		lieu.setLatitude(rs.getFloat("latitude"));
		lieu.setLongitude(rs.getFloat("longitude"));
		return lieu;
	}
}
