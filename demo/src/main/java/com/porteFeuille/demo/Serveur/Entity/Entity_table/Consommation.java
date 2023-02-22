package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.ConsommationId;
import com.porteFeuille.demo.Serveur.Entity.Object.PointFournitureId;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@IdClass(ConsommationId.class)
@Table(name = "Consommation")
public class Consommation {
    @Id
    private Long ean ;// represente le compteur numerique

    @Id
   // @ManyToOne
    //@JoinColumn(name = "habitation_id", referencedColumnName = "habitation_id")
    private Long habitation_id;
    int valeur;
    @Temporal(TemporalType.DATE)
    Date date;

    public Consommation() {
    }

    public Consommation(Long ean, Long habitation_id, int valeur, Date date) {
        this.ean = ean;
        this.habitation_id = habitation_id;
        this.valeur = valeur;
        this.date = date;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public Long getHabitation_id() {
        return habitation_id;
    }

    public void setHabitation_id(Long habitation_id) {
        this.habitation_id = habitation_id;
    }
}
