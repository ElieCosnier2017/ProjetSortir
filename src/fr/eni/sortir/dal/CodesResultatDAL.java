package fr.eni.sortir.dal;

public class CodesResultatDAL {

	/**
	 * Echec pendant tentative d'ajout d'un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000;

	/**
	 * Echec pendant tentative de suppression d'objet
	 */
	public static final int DELETE_OBJET_NULL=10001;

	/**
	 * Echec pendant tentative d'insertion d'un objet deja existant
	 */
	public static final int ALREADY_EXIST=10002;
    public static final int OBJECTS_DOESNT_MATCH = 10003 ;
}
