package fr.eni.sortir.bo;

import java.io.Serializable;
import java.sql.Date;

public class Sortie implements Serializable {

    private int idSortie;
    private String nom;
    private Date dateDebut;
    private int duree;
    private Date dateLimiteInscription;
    private int nbInscriptionsMax;
    private String infosSortie;
    private String etat;
    private String photo;

    public Sortie(String nom, Date dateHeureDebut, int duree, Date dateLimiteInscription, int nbInscriptionsMax, String infosSortie, String etat, String photo) {
        this.nom = nom;
        this.dateDebut = dateHeureDebut;
        this.duree = duree;
        this.dateLimiteInscription = dateLimiteInscription;
        this.nbInscriptionsMax = nbInscriptionsMax;
        this.infosSortie = infosSortie;
        this.etat = etat;
        this.photo = photo;
    }

    public int getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(int idSortie) {
        this.idSortie = idSortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    public Date getDateLimiteInscription() {
        return dateLimiteInscription;
    }

    public void setDateLimiteInscription(Date dateLimiteInscription) {
        this.dateLimiteInscription = dateLimiteInscription;
    }

    public int getNbInscriptionsMax() {
        return nbInscriptionsMax;
    }

    public void setNbInscriptionsMax(int nbInscriptionsMax) {
        this.nbInscriptionsMax = nbInscriptionsMax;
    }

    public String getInfosSortie() {
        return infosSortie;
    }

    public void setInfosSortie(String infosSortie) {
        this.infosSortie = infosSortie;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
