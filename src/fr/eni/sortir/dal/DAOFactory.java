package fr.eni.sortir.dal;

public abstract class DAOFactory {

	public static SortieDAO getSortieDAO() {
		return new SortieDAOJdbcImpl();
	}

	public static ParticipantDAO getParticipantDAO() {
		return new ParticipantDAOJdbcImpl();
	}

	public static LieuDAO getLieuDAO() {
		return new LieuDAOJdbcImpl();
	}

	public static InscriptionDAO getInscriptionDAO() {
		return new InscriptionDAOJdbcImpl();
	}

	public static EtatDAO getEtatDAO() {
		return new EtatDAOJdbcImpl();
	}

	public static VilleDAO getVilleDAO() {
		return new VilleDAOJdbcImpl();
	}

	public static SiteDAO getSiteDAO() {
		return new SiteDAOJdbcImpl();
	}
}
