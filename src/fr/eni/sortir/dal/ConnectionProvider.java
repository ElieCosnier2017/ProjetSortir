package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

abstract class ConnectionProvider {
	private static DataSource dataSource;
	
	/**
	 * Au chargement de la classe, la DataSource est recherchee dans l'arbre JNDI
	 */
	static
	{
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'acceder a la base de donnees");
		}
	}
	
	/**
	 * Cette methode retourne une connection operationnelle issue du pool de connexion
	 * vers la base de donnees. 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();
	}
}