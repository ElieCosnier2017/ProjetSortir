package fr.eni.sortir.dal;

public abstract class DAOFactory {

	public static SortieDAO getListeSortieDAO() {
		return new SortieDAOJdbcImpl();
	}

	public static ParticipantDAO getParticipantDAO() {
		return new ParticipantDAOJdbcImpl();
	}

	public static LieuDAO getLieuDAO() {
		return new LieuDAOJdbcImpl();
	}
}
