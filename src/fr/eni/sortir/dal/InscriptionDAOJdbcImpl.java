package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

public class InscriptionDAOJdbcImpl implements InscriptionDAO {

    private static final String INSERT = "INSERT INTO INSCRIPTIONS (date_inscription, sorties_no_sortie, participants_no_participant) VALUES (?,?,?)";
    private static final String COUNT_INSCRIPTION_BY_SORTIE = "COUNT * as nb FROM INSCRIPTIONS WHERE sorties_no_sortie = ?";

    @Override
    public void insert(int idSortie, int idParticipant) throws BusinessException {

        try (Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setDate(1, new Date(Calendar.getInstance().getTime().getTime()));
            pstmt.setInt(1, idSortie);
            pstmt.setInt(2, idParticipant);
            pstmt.executeUpdate();
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
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                nbPlaceRestante = rs.getInt("nb");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbPlaceRestante;
    }
}
