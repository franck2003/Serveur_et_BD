package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.ConsommationId;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Entity.Object.PointFournitureId;
import jakarta.persistence.*;

@Entity
@IdClass(ConsommationId.class)
@Table(name = "Consommation")
public class Consommation {
    @Id
    private Long ean ;// represente le compteur numerique
    @Id //creer une clé secondaire pour une habitation
    private Long habitation_id;

    @Column(name = "date")
    String dateDebut;
    int valeur;
    @Transient
    Date date;

    public Consommation() {
    }

    public Consommation(Long ean, Long habitation_id, String dateDebut, int valeur) {
        this.ean = ean;
        this.habitation_id = habitation_id;
        this.dateDebut = dateDebut;
        this.valeur = valeur;
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
