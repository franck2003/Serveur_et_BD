package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.PointFournitureId;
import jakarta.persistence.*;

@Entity
@Table(name = "pointFourniture", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ean", "pointFourniture"})})
public class PointFourniture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pointFournitureId;
    @Column(name = "ean")
    private Long ean;
    @Column(name = "pointFourniture")
    private String Pointfourniture;

    public PointFourniture(Long ean, String nomfournisseur) {
        this.ean = ean;
        this.Pointfourniture = nomfournisseur;
    }

    public PointFourniture() {
    }

    public PointFourniture(Long pointFournitureId) {
        this.pointFournitureId = pointFournitureId;
    }

    public PointFourniture(String fourniture) {
        this.Pointfourniture = fourniture;
    }

    public Long getPointFournitureId() {
        return pointFournitureId;
    }

    public void setPointFournitureId(Long pointFournitureId) {
        this.pointFournitureId = pointFournitureId;
    }

    public String getPointfourniture() {
        return Pointfourniture;
    }

    public void setPointfourniture(String pointfourniture) {
        Pointfourniture = pointfourniture;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public String getfournisseur() {
        return Pointfourniture;
    }

    public void setfournisseur(String nom_fournisseur) {
        this.Pointfourniture = nom_fournisseur;
    }
}
