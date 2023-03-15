package com.porteFeuille.demo.Serveur.Entity.Entity_table;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
/*
inserer une clé etrangère dans un contrat
 */

@Entity
@Embeddable
@Table(name = "Contrat", uniqueConstraints= {
        @UniqueConstraint(columnNames = {"pointFournitureId", "compteur", "habitation_Id"})})
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero_contrat;
    @ManyToOne
    @JoinColumn(name = "consommateur_id")
    private Consommateur consommateurId;

    @Column(nullable = false, name = "compteur", columnDefinition = "VARCHAR(50)")
    private String compteur = "OUVERT";

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "fournisseur_id")
    private Fournisseur fournisseur_id;

    @ManyToOne
    @JoinColumn(name = "habitation_id")
    private Habitation habitationId;

    @ManyToOne
    @JoinColumn(name = "pointFournitureId")
    private PointFourniture pointFournitureId;
    @Temporal(TemporalType.DATE)
    private Date date_debut;

    public PointFourniture getPointFournitureId() {
        return pointFournitureId;
    }

    public void setPointFournitureId(PointFourniture pointFournitureId) {
        this.pointFournitureId = pointFournitureId;
    }

    public Habitation getHabitation() {
        return habitationId;
    }

    public void setHabitation(Habitation habitationId) {
        this.habitationId = habitationId;
    }

    public Consommateur getConsommateurId() {
        return consommateurId;
    }

    public void setConsommateurId(Consommateur consommateurId) {
        this.consommateurId = consommateurId;
    }

    public Contrat() {
    }

    public Contrat(Long numero_contrat) {
        this.numero_contrat = numero_contrat;
    }

    public Contrat(Consommateur consommateurId, String compteur, Fournisseur fournisseur_id, Habitation habitationId, PointFourniture pointFournitureId, Date date_debut) {
        this.consommateurId = consommateurId;
        this.compteur = compteur;
        this.fournisseur_id = fournisseur_id;
        this.habitationId = habitationId;
        this.pointFournitureId = pointFournitureId;
        this.date_debut = date_debut;
    }

    public Fournisseur getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(Fournisseur fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public Long getNumero_contrat() {
        return numero_contrat;
    }

    public void setNumero_contrat(Long numero_contrat) {
        this.numero_contrat = numero_contrat;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public String getCompteur() {
        return compteur;
    }

    public void setCompteur(String compteur) {
        this.compteur = compteur;
    }
}
