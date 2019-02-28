package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InscriptionDAOJdbcImpl implements InscriptionDAO {

    private static final String SELECTBYID = "SELECT count(*) as nb FROM INSCRIPTIONS WHERE sorties_no_sortie=? AND participants_no_participant=?";
    private static final String INSERT = "INSERT INTO INSCRIPTIONS (date_inscription, sorties_no_sortie, participants_no_participant) VALUES (GETDATE(),?,?)";
    private static final String DELETE = "DELETE FROM INSCRIPTIONS WHERE sorties_no_sortie=? AND participants_no_participant=?";

    private static final String COUNT_INSCRIPTION_BY_SORTIE = "SELECT COUNT(*) as nb FROM INSCRIPTIONS WHERE sorties_no_sortie = ?";

    @Override
    public void insert(int idSortie, int idParticipant) throws BusinessException {

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT);
            pstmt.setInt(1, idSortie);
            pstmt.setInt(2, idParticipant);
            pstmt.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }

    }

    @Override
    public Integer count(int idSortie) {
        Integer nbPlaceRestante = null;
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(COUNT_INSCRIPTION_BY_SORTIE);
            pstmt.setInt(1, idSortie);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nbPlaceRestante = rs.getInt("nb");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbPlaceRestante;
    }

    @Override
    public void delete(Integer idSortie, Integer idParticipant) throws BusinessException {
        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE);
            pstmt.setInt(1, idSortie);
            pstmt.setInt(2, idParticipant);
            pstmt.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJET_NULL);
            throw businessException;
        }
    }

    @Override
    public Boolean estInscrit(int idSortie, int idParticipant) {
        Boolean result = false;
        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
            pstmt.setInt(1, idSortie);
            pstmt.setInt(2, idParticipant);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(rs.getInt("nb") ==  1) {
                    result = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
