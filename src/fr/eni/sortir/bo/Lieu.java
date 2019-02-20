package fr.eni.sortir.bo;

import java.io.Serializable;

public class Lieu implements Serializable {

    private int idLieu;
    private String nom;
    private String rue;
    private float latitude;
    private float longitude;

     public Lieu(int idLieu, String nom, String rue, float latitude, float longitude) {
        this.idLieu = idLieu;
        this.nom = nom;
        this.rue = rue;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
