package fr.eni.sortir.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Participant;

public class ParticipantDAOJdbcImpl implements  ParticipantDAO{
	
	/* REQUETES */
	private static final String INSERT="INSERT INTO PARTICIPANTS (nom, prenom, telephone, mail, pseudo, mot_de_passe, administrateur, actif, sites_no_site) VALUES (?,?,?,?,?,?,0,1,1)";
	private static final String UPDATE = "UPDATE PARTICIPANTS SET nom=?, prenom=?, telephone=?, mail=?, pseudo=?, mot_de_passe=? WHERE no_participant=?";
	private static final String DELETE="DELETE FROM PARTICIPANTS WHERE idParticipant=?";
	private static final String SELECT_ALL="SELECT nom, prenom, telephone, mail, administrateur, actif, FROM PARTICIPANTS" ;
	private static final String SELECT_ONE_BY_ID="SELECT no_participant, nom, prenom, telephone,pseudo, mail, administrateur, mot_de_passe, actif, sites_no_site FROM PARTICIPANTS WHERE no_participant=? ";
	private static final String SELECT_ONE_BY_EMAIL_AND_PASSWORD="SELECT * FROM PARTICIPANTS WHERE (mail=? OR pseudo=?) AND mot_de_passe= ? AND actif = ?";

	/**
	 * Methode qui permet d'ajouter un participant.
	 */
	@Override
	public void insert(Participant participant) throws BusinessException {
		if (participant == null) 
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, participant.getNom());
			pstmt.setString(2, participant.getPrenom());
			pstmt.setString(3, participant.getTelephone());
			pstmt.setString(4, participant.getMail());
			pstmt.setString(5, participant.getPseudo());
			pstmt.setString(6, participant.getPassword());
			pstmt.execute();
			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next())
			{
				participant.setIdparticipant(rs.getInt(1));
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
	public Participant update(Participant participant) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
			pstmt.setString(1, participant.getNom());
			pstmt.setString(2, participant.getPrenom());
			pstmt.setString(3, participant.getTelephone());
			pstmt.setString(4, participant.getMail());
			pstmt.setString(5, participant.getPseudo());
			pstmt.setString(6, participant.getPassword());
			pstmt.setInt(7, participant.getIdparticipant());


			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			throw new SQLException(e);
		}
		return participant;
	}
	
	/**
	 * Methode qui permet de supprimer un �l�ment.
	 */
	@Override
	public void delete(int idParticipant) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, idParticipant);
			pstmt.execute();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * Methode qui selectionne tous les elements.
	 */
	@Override
	public List<Participant> selectAll() throws BusinessException {
		List<Participant> listesParticipants = new ArrayList<Participant>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement pstmt = cnx.createStatement();
			ResultSet rs = pstmt.executeQuery(SELECT_ALL);

			while(rs.next())
			{
				listesParticipants.add(this.participantBuilder(rs));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listesParticipants;
	}

	@Override
	public Participant selectByEmailAndPassword(String emailOrPseudo, String mdp) throws BusinessException {
		Participant participant = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_EMAIL_AND_PASSWORD);
			pstmt.setString(1, emailOrPseudo);
			pstmt.setString(2, emailOrPseudo);
			pstmt.setString(3, mdp);
			pstmt.setString(4, "1");
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				participant = this.participantBuilder(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return participant;
	}

		/**
	 * M�thode qui r�cup�re tous les �l�ments de la table PARTICIPANTS pour un ID donn�
	 */
	@Override
	public Participant selectById(int idParticipant) throws SQLException {
		Participant participant = null;

		try (Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE_BY_ID);
			pstmt.setInt(1, idParticipant);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
			{
				participant = this.participantBuilder(rs);
			}
		} catch (SQLException e)
		{
			throw new SQLException(e);
		}
		return participant;
	}
	
	/**
	 * 
	 * @param rs rs
	 * @return participantCourant
	 * @throws SQLException SQLException
	 */
	public Participant participantBuilder(ResultSet rs) throws SQLException {
		Participant participant;
		participant = new Participant();
		participant.setIdparticipant(rs.getInt("no_participant"));
		participant.setNom(rs.getString("nom"));
		participant.setPrenom(rs.getString("prenom"));
		participant.setTelephone(rs.getString("telephone"));
		participant.setMail(rs.getString("mail"));
		participant.setPseudo(rs.getString("pseudo"));
		participant.setPassword(rs.getString("mot_de_passe"));
		participant.setAdministrateur(rs.getBoolean("administrateur"));
		participant.setActif(rs.getBoolean("actif"));
		participant.setSite(rs.getInt("sites_no_site"));

		return participant;
	}
}
