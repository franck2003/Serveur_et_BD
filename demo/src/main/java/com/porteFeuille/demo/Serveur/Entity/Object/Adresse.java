package com.porteFeuille.demo.Serveur.Entity.Object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adresse {

    private String rue;
    private int numero;
    private String batiment;
    private String ville;
    private int code_postale;

    public Adresse() {
    }

    public Adresse(String rue, int numero, String batiment, String ville, int code_postale) {
        this.rue = rue;
        this.numero = numero;
        this.batiment = batiment;
        this.ville = ville;
        this.code_postale = code_postale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(int code_postale) {
        this.code_postale = code_postale;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "rue='" + rue + '\'' +
                ", numero=" + numero +
                ", batiment='" + batiment + '\'' +
                ", ville='" + ville + '\'' +
                ", code_postale=" + code_postale +
                '}';
    }
}
