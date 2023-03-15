package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.*;
import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;
import com.porteFeuille.demo.Serveur.Repositories.PointFournitureRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Configuration
public class ContratConfig {
    @Autowired
    ContratRepositories repositories;
    @Bean
    CommandLineRunner ajouterContrat() {
        return args ->{
            Fournisseur fournisseur = new Fournisseur(2002L);
            Consommateur consommateur = new Consommateur(2L);
            PointFourniture pointFourniture = new PointFourniture( 102L);
            Habitation habitation = new Habitation(1252L);
            Contrat contrat = new Contrat(consommateur, "ouvert",fournisseur,habitation,pointFourniture,new Date());
            try{
                repositories.save(contrat);
            }catch (DataIntegrityViolationException e){
                System.out.println("violation de la contrainte clé unique ");
            }

        };
    }
    @Bean
    CommandLineRunner femerCompteur(){
        return args -> {
                PointFourniture pointFourniture = new PointFourniture(102L);
                Habitation habitation = new Habitation(1252L);
               // repositories.updateCompteurByCompteurAndHabitationIdAndPointFournitureId("ferme","ouvert",habitation,pointFourniture);
                System.out.println("bonjour");
                System.out.println("bonjour");
        };
    }
/*
    @Bean
    CommandLineRunner ouvrirCompteur(){
        return args -> {
            repositories.updateCompteurByClient_idAndEanAndFournisseur_idAndCompteur("OUVERT",187L,new PointFourniture(946430795197304526L), new Fournisseur(52L),"FERME");
        };
    }
    @Bean
    CommandLineRunner fermerCompteur(){
        return args -> {
           repositories.updateCompteurByClient_idAndEanAndFournisseur_idAndCompteur("FERME",187L,new PointFourniture(946430795197304526L), new Fournisseur(52L),"OUVERT");
        };
    }*/
    public List<Date> generatesDates(){
        List<Date> dates = new ArrayList<>();
        dates.add(new Date());
        Date dateFin = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        dateFin.setTime(calendar.getTimeInMillis());
        dates.add(dateFin);
        return dates;
    }
}
