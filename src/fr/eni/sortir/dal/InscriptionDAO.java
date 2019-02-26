package fr.eni.sortir.dal;

import fr.eni.sortir.bll.BusinessException;

public interface InscriptionDAO {
    void insert(int idSortie, int idParticipant) throws BusinessException;
    Integer count(int idSortie);

    void delete(Integer idSortie, Integer idParticipant) throws BusinessException;
}
