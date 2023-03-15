package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.List;
@CrossOrigin
@Entity
@Table(name = "Fournisseur", uniqueConstraints= {
        @UniqueConstraint(columnNames = {"email"})})
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fournisseur_id")
    private Long fournisseur_id;
    private String nom_fournisseur;

    @ManyToOne
    @JoinColumn(name = "point_fourniture_id")
    private PointFourniture pointFourniture;

    private Long cout;

    private String siege;
    @Transient
    private Adresse adresse;
    @Column(unique = true)
    private String email;

    public Fournisseur(String nomFournisseur, Object o, Object o1, String email) {
    }

    public PointFourniture getPointFourniture() {
        return pointFourniture;
    }

    public void setPointFourniture(PointFourniture pointFourniture) {
        this.pointFourniture = pointFourniture;
    }

    /*j'ai supprime la liste de contrat parce qu'on va utiliser la base de donnnees pour
      recuperer les elements infos sur le contrat
      et rajouter le nom de l'adrese email*/
    public Fournisseur() {
    }

    public Fournisseur(Long fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public Fournisseur(String nom_fournisseur, PointFourniture pointFourniture, String siege, String email,Long cout) {
        this.nom_fournisseur = nom_fournisseur;
        this.pointFourniture = pointFourniture;
        this.cout = cout;
        this.siege = siege;
        this.email = email;
    }

    public Long getCout() {
        return cout;
    }

    public void setCout(Long cout) {
        this.cout = cout;
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
