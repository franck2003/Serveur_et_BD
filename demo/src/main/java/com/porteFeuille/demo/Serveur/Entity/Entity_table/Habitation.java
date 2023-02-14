package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import jakarta.persistence.*;

@Entity
@Table(name = "Habitation")
public class Habitation{

    @Id
    private Long habitationId;

    private Long ean;
    private String adresse;
    @Transient
    private Adresse siege;

    public Habitation() {
    }

    public Habitation(Long habitationId, Long ean, int compteur, Adresse siege) {
        this.habitationId = habitationId;
        this.ean = ean;
        this.siege = siege;
    }

    public Habitation(Long habitationId, Long ean, String adresse) {
        this.habitationId = habitationId;
        this.adresse = adresse;
        this.ean = ean;
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

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public Adresse getSiege() {
        return siege;
    }

    public void setSiege(Adresse siege) {
        this.siege = siege;
    }
}
