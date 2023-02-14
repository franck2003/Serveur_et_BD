package com.porteFeuille.demo.Serveur.Entity.Object;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.ServicePaiement;

public class ServicePaiementMock implements ServicePaiement {
    @Override
    public boolean payer(Double montant) {
        return false;
    }
}
