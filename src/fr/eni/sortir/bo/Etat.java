package fr.eni.sortir.bo;

import java.io.Serializable;

public class Etat implements Serializable {

    private int idEtat;
    private String libelle;

    public Etat() {}

    public Etat(int idEtat, String libelle) {
        this.idEtat = idEtat;
        this.libelle = libelle;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(int idEtat) {
        this.idEtat = idEtat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
