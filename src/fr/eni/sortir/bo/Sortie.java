package fr.eni.sortir.bo;

import java.io.Serializable;
import java.util.Date;

public class Sortie implements Serializable {

    private int idSortie;
    private String nom;
    private Date dateHeureDebut;
    private int dur�e;
    private Date dateLimiteInscription;
    private int nbInscriptionsMax;
    private String infosSortie;
    private String etat;

    public Sortie(int idSortie, String nom, Date dateHeureDebut, int dur�e, Date dateLimiteInscription, int nbInscriptionsMax, String infosSortie, String etat) {
        this.idSortie = idSortie;
        this.nom = nom;
        this.dateHeureDebut = dateHeureDebut;
        this.dur�e = dur�e;
        this.dateLimiteInscription = dateLimiteInscription;
        this.nbInscriptionsMax = nbInscriptionsMax;
        this.infosSortie = infosSortie;
        this.etat = etat;
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

    public Date getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Date dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public int getDur�e() {
        return dur�e;
    }

    public void setDur�e(int dur�e) {
        this.dur�e = dur�e;
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
}
