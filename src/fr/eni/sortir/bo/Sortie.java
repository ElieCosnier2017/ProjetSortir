package fr.eni.sortir.bo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
    private int organisateur;
    private int idLieu;
    private int idEtat;

    public Sortie(){
    }

    public Sortie(String nom, Date dateHeureDebut, int duree, Date dateLimiteInscription, int nbInscriptionsMax, String infosSortie, String etat, String photo, int organisateur, int idLieu, int idEtat) {
        this.nom = nom;
        this.dateDebut = dateHeureDebut;
        this.duree = duree;
        this.dateLimiteInscription = dateLimiteInscription;
        this.nbInscriptionsMax = nbInscriptionsMax;
        this.infosSortie = infosSortie;
        this.etat = etat;
        this.photo = photo;
        this.organisateur = organisateur;
        this.idLieu = idLieu;
        this.idEtat = idEtat;
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

    public String getDateDebut(String format){
        SimpleDateFormat formater = new SimpleDateFormat(format);
        formater.setTimeZone(TimeZone.getTimeZone("ARI"));
        return formater.format(dateDebut);
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

    public int getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(int organisateur) {
        this.organisateur = organisateur;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public void setidEtat(int idEtat) {
        this.idEtat = idEtat;
    }

    @Override
    public String toString() {
        return "{" +
                "idSortie=" + idSortie +
                ", nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", duree=" + duree +
                ", dateLimiteInscription=" + dateLimiteInscription +
                ", nbInscriptionsMax=" + nbInscriptionsMax +
                ", infosSortie='" + infosSortie + '\'' +
                ", etat='" + etat + '\'' +
                ", photo='" + photo + '\'' +
                ", organisateur='" + organisateur + '\'' +
                ", idLieu=" + idLieu +
                ", idEtat=" + idEtat +
                '}';
    }
}
