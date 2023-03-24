package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import com.porteFeuille.demo.Serveur.Repositories.ConsommateurRepositories;
import com.porteFeuille.demo.Serveur.Repositories.ConsommationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Calendar;
import java.util.Date;


@Configuration
public class ConsommationConfig{
    @Autowired
    ConsommationRepositories repositories;
    @Autowired
    ConsommateurRepositories consommateurRepositories;
/*
    @Bean
    CommandLineRunner ajouterDonneesDeConsommation(){
        return args ->{
            Habitation habitation = new Habitation( 11002L);
            PointFourniture pointFourniture = new PointFourniture(102L);
            Consommation consommation = new Consommation(pointFourniture,habitation, 14, new Date());
            try {
                repositories.save(consommation);
            }catch (DataIntegrityViolationException e){
                System.out.println("valeur presente");
            }
        };
    }/*
est ce que a chaque fin du mois je dois save la meme habitation et reset la valeur a 0
 */
}
