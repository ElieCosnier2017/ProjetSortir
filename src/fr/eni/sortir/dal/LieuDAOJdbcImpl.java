package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bo.Lieu;

public class LieuDAOJdbcImpl implements LieuDAO{
	private static final String SELECT_ALL = "SELECT * FROM Lieux";
	
	@Override
	public List<Lieu> selectAll() {
		List<Lieu> listeLieu = new ArrayList<Lieu>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("nom_lieu"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listeLieu;
	}
}
