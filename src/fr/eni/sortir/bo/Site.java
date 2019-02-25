package fr.eni.sortir.bo;

import java.io.Serializable;

public class Site implements Serializable {

    private int idSite;
    private String nom;

    public Site(){
    }

    public Site(int idSite, String nom) {
        this.idSite = idSite;
        this.nom = nom;
    }

    public Site(int idSite) {
        this.idSite = idSite;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
