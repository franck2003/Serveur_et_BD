package com.porteFeuille.demo.Serveur.Entity.Object;


import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class ConsommationId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "point_fourniture_id")
    PointFourniture pointFournitureId ;// represente le compteur numerique
    @ManyToOne
    @JoinColumn(name = "habitationId")
    Habitation habitationId;

    public PointFourniture getPointFournitureId() {
        return pointFournitureId;
    }

    public void setPointFournitureId(PointFourniture pointFournitureId) {
        this.pointFournitureId = pointFournitureId;
    }

    public Habitation getHabitation_id() {
        return habitationId;
    }

    public void setHabitation_id(Habitation habitation_id) {
        this.habitationId = habitation_id;
    }

}