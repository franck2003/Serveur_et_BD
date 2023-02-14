package com.porteFeuille.demo.Serveur.Entity.Object;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class ConsommationId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long ean ;// represente le compteur numerique
    Long habitation_id;

}