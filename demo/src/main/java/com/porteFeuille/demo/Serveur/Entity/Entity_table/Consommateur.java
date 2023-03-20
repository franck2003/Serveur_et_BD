package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Consommateur", uniqueConstraints= {
        @UniqueConstraint(columnNames = {"Email"})})
public class Consommateur  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ConsommateurId")
    private Long ConsommateurId;
    private String Prenom;
    private String Nom;

    private String motDePasse;

    private String email;

    //ajouter un champs mot de passe et le supprimer dans la classe login
    public Consommateur() {
    }

    public Consommateur(Long consommateurId) {
        ConsommateurId = consommateurId;
    }
    public Consommateur(String nom, String prenom,  String email, String motDePasse) {
        Prenom = prenom;
        Nom = nom;
        this.motDePasse = motDePasse;
        this.email = email;
    }

    public void setConsommateurId(Long consommateurId) {
        ConsommateurId = consommateurId;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setNom(String nom) {
        Nom = nom;
    }

    public void setNom_Consommateur(String nom_Consommateur) {
        Nom = nom_Consommateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return Prenom;
    }

    public Long getConsommateurId() {
        return ConsommateurId;
    }

    public String getNom() {
        return Nom;
    }
}
