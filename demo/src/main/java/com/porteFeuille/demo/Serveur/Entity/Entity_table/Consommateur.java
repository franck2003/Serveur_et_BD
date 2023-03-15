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
    private String Email;
    public Consommateur() {
    }

    public Consommateur(Long consommateurId) {
        ConsommateurId = consommateurId;
    }

    public Consommateur(String Nom, String Prenom, String Email) {
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Email = Email;
    }

    public void setConsommateurId(Long consommateurId) {
        ConsommateurId = consommateurId;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setNom_Consommateur(String nom_Consommateur) {
        Nom = nom_Consommateur;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
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
