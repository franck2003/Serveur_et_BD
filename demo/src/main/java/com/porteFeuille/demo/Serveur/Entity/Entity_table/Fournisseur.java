package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Fournisseur")
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fournisseur_id")
    private Long fournisseur_id;
    private String nom_fournisseur;

    private String siege;
    @Transient
    private Adresse adresse;
    private String email;
    /*j'ai supprime la liste de contrat parce qu'on va utiliser la base de donnnees pour
      recuperer les elements infos sur le contrat
      et rajouter le nom de l'adrese email*/
    public Fournisseur() {
    }

    public Fournisseur(Long fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public Fournisseur(String nom_fournisseur, String siege, String email) {
        this.nom_fournisseur = nom_fournisseur;
        this.siege = siege;
        this.email = email;
    }

    public Long getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(Long fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
