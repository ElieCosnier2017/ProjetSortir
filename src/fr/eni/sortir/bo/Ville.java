package fr.eni.sortir.bo;

import java.io.Serializable;

public class Ville implements Serializable {

    private int idVille;
    private String nom;
    private int codePostal;

    public Ville(int idVille, String nom, int codePostal) {
        this.idVille = idVille;
        this.nom = nom;
        this.codePostal = codePostal;
    }

    public Ville(){}

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
}
