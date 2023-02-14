package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "Facturation")
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String numeroFacture;
    private String nomFournisseur;
    private String siege;
    @Transient
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
