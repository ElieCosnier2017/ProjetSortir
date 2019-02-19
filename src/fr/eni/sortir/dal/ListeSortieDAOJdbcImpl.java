package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bo.Sortie;

public class ListeSortieDAOJdbcImpl implements ListeSortieDAO {
	private static final String SELECT_ALL = "SELECT * FROM ETATS";

	@Override
	public List<Sortie> selectAll() {
		List<Sortie> listeSortie = new ArrayList<Sortie>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("nom"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listeSortie;
	}
}
