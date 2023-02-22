package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import jakarta.persistence.*;

@Entity

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "fournisseur_id")
    private Fournisseur fournisseur_id;

    /*@ManyToOne
    @JoinColumn(name = "consommateur_id", referencedColumnName = "consommateur_id")
    Consommateur consommateur_id;

     */
    String status;

    String json;

    public Notification() {
    }

    public Notification(Fournisseur fournisseur_id, String status, String json) {
        this.fournisseur_id = fournisseur_id;
        this.status = status;
        this.json = json;
    }

    public Fournisseur getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(Fournisseur fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
