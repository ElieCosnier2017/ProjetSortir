package fr.eni.sortir.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.sortir.bll.BusinessException;
import fr.eni.sortir.bo.Participant;

public interface ParticipantDAO {
	
	List<Participant> selectAll() throws BusinessException;
	
	void insert(Participant participant) throws BusinessException;
	
	Participant update(Participant participant) throws SQLException;
	
	void delete(int idParticipant) throws BusinessException;
	
	 Participant selectById(int idParticipant) throws SQLException;
}
