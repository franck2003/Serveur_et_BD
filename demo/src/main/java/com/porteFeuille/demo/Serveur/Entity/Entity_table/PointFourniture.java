package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.PointFournitureId;
import jakarta.persistence.*;

@Entity
@IdClass(PointFournitureId.class)
@Table(name = "pointFournitures")
public class PointFourniture {
    @Id
    @Column(name = "ean")
    private Long ean;
    @Id
    @Column(name = "pointFourniture")
    private String fourniture;

    public PointFourniture(Long ean, String nomfournisseur) {
        this.ean = ean;
        this.fourniture = nomfournisseur;
    }

    public PointFourniture() {
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public String getfournisseur() {
        return fourniture;
    }

    public void setfournisseur(String nom_fournisseur) {
        this.fourniture = nom_fournisseur;
    }
}
