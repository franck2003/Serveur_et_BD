package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import jakarta.persistence.*;

@Entity
@Table(name = "Habitation" , uniqueConstraints= {
        @UniqueConstraint(columnNames = {"adresse", "pointFournitureId"})})
public class Habitation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "habitationId")
    private Long habitationId;

    @ManyToOne
    @JoinColumn(name = "pointFournitureId")
    private PointFourniture pointFournitureId;

    private String adresse;

    @ManyToOne
    @JoinColumn(name = "consommateur_id")
    private Consommateur consommateur_id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseurId;
    @Transient
    private Adresse siege;

    public Fournisseur getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Fournisseur fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public PointFourniture getPointFourniture() {
        return pointFournitureId;
    }

    public void setPointFourniture(PointFourniture pointFourniture) {
        this.pointFournitureId= pointFourniture;
    }

    public Habitation() {
    }

    public Habitation(PointFourniture pointFourniture, String adresse, Consommateur consommateur_id, Fournisseur fournisseurId) {
        this.pointFournitureId = pointFourniture;
        this.adresse = adresse;
        this.consommateur_id = consommateur_id;
        this.fournisseurId = fournisseurId;
    }

    public Habitation(Long l) {
        this.habitationId = l;
    }

    public Long getHabitationId() {
        return habitationId;
    }

    public void setHabitationId(Long habitationId) {
        this.habitationId = habitationId;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Adresse getSiege() {
        return siege;
    }

    public void setSiege(Adresse siege) {
        this.siege = siege;
    }

    public Consommateur getConsommateur_id() {
        return consommateur_id;
    }

    @Override
    public String toString() {
        return "Habitation{" +
                "habitationId=" + habitationId +
                ", ean=" + pointFournitureId +
                ", adresse='" + adresse + '\'' +
                ", consommateur_id=" + consommateur_id +
                ", siege=" + siege +
                '}';
    }

    public void setConsommateur_id(Consommateur consommateur_id) {
        this.consommateur_id = consommateur_id;
    }
}
