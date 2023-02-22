package com.porteFeuille.demo.Serveur.Entity.Entity_table;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
/*
inserer une clé etrangère dans un contrat
 */

@Entity
@Embeddable
@Table(name = "Contrat")
public class Contrat implements Serializable {
    @Id
    private Long numero_contrat;
    /*@ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")*/
    private Long client_id;


    @Column(nullable = false, name = "compteur", columnDefinition = "VARCHAR(50)")
    private String compteur = "OUVERT";

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", referencedColumnName = "fournisseur_id")
    private Fournisseur fournisseur_id;

    @ManyToOne
    @JoinColumn(name = "ean", referencedColumnName = "ean")
    private  PointFourniture ean;
    @Temporal(TemporalType.DATE)
    private Date date_debut;
    @Temporal(TemporalType.DATE)
    private Date date_fin;

    public Contrat() {
    }

    public Contrat(Long numero_contrat, Long client_id, Fournisseur fournisseur_id, PointFourniture ean, Date date_debut) {
        this.numero_contrat = numero_contrat;
        this.client_id = client_id;
        this.fournisseur_id = fournisseur_id;
        this.ean = ean;
        this.date_debut = date_debut;
    }

    public Contrat(Long numero_contrat) {
        this.numero_contrat = numero_contrat;
    }

    public Fournisseur getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(Fournisseur fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getNumero_contrat() {
        return numero_contrat;
    }

    public void setNumero_contrat(Long numero_contrat) {
        this.numero_contrat = numero_contrat;
    }

    public PointFourniture getEan() {
        return ean;
    }

    public void setEan(PointFourniture ean) {
        this.ean = ean;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getCompteur() {
        return compteur;
    }

    public void setCompteur(String compteur) {
        this.compteur = compteur;
    }
}
