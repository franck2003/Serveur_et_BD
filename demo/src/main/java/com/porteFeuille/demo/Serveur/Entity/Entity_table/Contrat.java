package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Embeddable
@Table(name = "Contrat")
public class Contrat implements Serializable {
    @Id
    private Long numero_contrat;
    private Long client_id;

    /*@ManyToOne(targetEntity = Fournisseur.class)
    @JoinColumn(name = "nom_fournisseur")*/
    private String nom_fournisseur;

    private  Long ean;

    private String debutContrat;

    private String finContrat;
    @Transient
    private Date date_debut;
   @Transient
    private Date date_fin;

    public Contrat() {
    }

    public Contrat(Long numero_contrat, Long client_id, String nom_fournisseur, Long ean, String debut_contrat, String fin_contrat) {
        this.numero_contrat = numero_contrat;
        this.client_id = client_id;
        this.nom_fournisseur = nom_fournisseur;
        this.ean = ean;
        this.debutContrat= debut_contrat;
        this.finContrat = fin_contrat;
    }

    public String getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(String debutContrat) {
        this.debutContrat = debutContrat;
    }

    public String getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(String finContrat) {
        this.finContrat = finContrat;
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

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
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

    public String getNom_fournisseur() {
        return this.nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }
}
