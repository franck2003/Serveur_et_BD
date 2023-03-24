package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Facturation")
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_facture", nullable = false)
    private Long numero_facture;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
    @ManyToOne
    @JoinColumn(name = "consommateur_id")
    private Consommateur consommateur;

    @ManyToOne
    @JoinColumn(name = "habitation_id")
    private Habitation habitation;
    @ManyToOne
    @JoinColumn(name = "accounte_mentuel_id")
    private AccounteMentuel accounteMentuel;

    public Facturation(Fournisseur fournisseur, Consommateur consommateur, Habitation habitation, AccounteMentuel accounteMentuel) {
        this.fournisseur = fournisseur;
        this.consommateur = consommateur;
        this.habitation = habitation;
        this.accounteMentuel = accounteMentuel;
    }

    public Long getNumero_facture() {
        return numero_facture;
    }


    public void setNumero_facture(Long numero_facture) {
        this.numero_facture = numero_facture;
    }

    public AccounteMentuel getAccounteMentuel() {
        return accounteMentuel;
    }

    public void setAccounteMentuel(AccounteMentuel accounteMentuel) {
        this.accounteMentuel = accounteMentuel;
    }

    public Habitation getHabitation() {
        return habitation;
    }

    public void setHabitation(Habitation habitation) {
        this.habitation = habitation;
    }

    public Consommateur getConsommateur() {
        return consommateur;
    }

    public void setConsommateur(Consommateur consommateur) {
        this.consommateur = consommateur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

}
