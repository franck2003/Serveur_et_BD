package com.porteFeuille.demo.Serveur.Entity.Object;


import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class PointFournitureId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long ean;
    private String fourniture;
}
