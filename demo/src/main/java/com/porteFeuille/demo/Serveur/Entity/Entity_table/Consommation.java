package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.ConsommationId;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@IdClass(ConsommationId.class)
@Table(name = "Consommation")
public class Consommation {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "point_fourniture_id", nullable = false)
    private PointFourniture pointFournitureId;
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "habitation_id", nullable = false)
    private Habitation habitationId;
    int valeur;
    @Temporal(TemporalType.DATE)
    Date date;

    public PointFourniture getPointFournitureId() {
        return pointFournitureId;
    }

    public void setPointFournitureId(PointFourniture pointFournitureId) {
        this.pointFournitureId = pointFournitureId;
    }

    public PointFourniture getPointFourniture() {
        return pointFournitureId;
    }

    public void setPointFourniture(PointFourniture pointFournitureId) {
        this.pointFournitureId = pointFournitureId;
    }

    public Habitation getHabitationId() {
        return habitationId;
    }

    public void setHabitationId(Habitation habitationId) {
        this.habitationId = habitationId;
    }


    public Consommation(long ean, long l, int valeur, Date date) {
    }

    public Consommation() {
    }

    public Consommation(PointFourniture pointFourniture, Habitation habitation_id, int valeur, Date date) {
        this.pointFournitureId = pointFourniture;
        this.habitationId = habitation_id;
        this.valeur = valeur;
        this.date = date;
    }

    public int getValeur() {
        return valeur;
    }

    public Date getDate() {
        return date;
    }

    public Habitation getHabitation_id() {
        return habitationId;
    }

    public void setHabitation_id(Habitation habitation_id) {
        this.habitationId = habitation_id;
    }
}
