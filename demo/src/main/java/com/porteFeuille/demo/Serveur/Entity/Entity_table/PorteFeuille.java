package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Portefeuille", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"habitationId", "consommateur_id"})})
public class PorteFeuille {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "habitationId")
    private Habitation habitationId;

    @ManyToOne
    @JoinColumn(name = "consommateur_id")
    private Consommateur consommateurId;

    public PorteFeuille() {
    }

    public PorteFeuille(Consommateur consommateurId, Habitation habitationId) {
        this.habitationId = habitationId;
        this.consommateurId = consommateurId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habitation getHabitationId() {
        return habitationId;
    }

    public void setHabitationId(Habitation habitationId) {
        this.habitationId = habitationId;
    }

    public Consommateur getConsommateurId() {
        return consommateurId;
    }

    public void setConsommateurId(Consommateur consommateurId) {
        this.consommateurId = consommateurId;
    }

}
