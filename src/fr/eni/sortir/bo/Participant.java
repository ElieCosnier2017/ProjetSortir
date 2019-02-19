package fr.eni.sortir.bo;

import java.io.Serializable;

public class Participant implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idparticipant;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private boolean administrateur;
    private boolean actif;
    
	public Participant() {		
	}
	
    public Participant(String nom, String prenom, String telephone, String mail, boolean administrateur,
			boolean actif) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.mail = mail;
		this.administrateur = administrateur;
		this.actif = actif;
	}

	public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdparticipant() {
        return idparticipant;
    }

    public void setIdparticipant(int idparticipant) {
        this.idparticipant = idparticipant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
