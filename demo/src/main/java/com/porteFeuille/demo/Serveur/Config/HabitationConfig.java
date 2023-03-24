package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.*;
import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.HabitationRepositories;
import com.porteFeuille.demo.Serveur.Repositories.PointFournitureRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

@Configuration
public class HabitationConfig {
    @Autowired
    private HabitationRepositories repositories;

    @Autowired
    private PointFournitureRepositories pointFournitureRepositories;
    /*
    @Bean
    CommandLineRunner ajouterHabitation(){
        return args ->{
            Consommateur consommateur = new Consommateur(7152L);
            Adresse adresse = new Adresse("roiAlbert",642,"maison","Mons",7012);
            PointFourniture pointFourniture = new PointFourniture(102L);
            Fournisseur fournisseur = new Fournisseur(2002L);
            Habitation c = new Habitation(pointFourniture,adresse.toString(),consommateur, fournisseur);
            try {
                repositories.save(c);
            }catch (DataIntegrityViolationException e){
                System.out.println("l'information existe sur la l'habitation existe dans la base de données");
            }
        };
    }*/
}
