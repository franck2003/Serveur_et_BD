package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Configuration
public class ContratConfig {
    @Autowired
    ContratRepositories repositories;

    @Bean
    CommandLineRunner ajouterContrat(){
        return args ->{
            List<Date> dates = generatesDates();
            Fournisseur fournisseur = new Fournisseur(52L);
            PointFourniture pointFourniture = new PointFourniture(946430795197304526L);
            Contrat contrat = new Contrat(15L, 187L,fournisseur,pointFourniture,new Date());
            if (repositories.findByNumero_contrat(contrat.getNumero_contrat()).isEmpty()) {
                repositories.save(contrat);
            }
        };
    }

    @Bean
    CommandLineRunner suppimerContrat(){
        return args -> {
            if (repositories.findByNumero_contrat(102L).isPresent()) {
               //repositories.deleteByNumero_contrat(102L);
            }
    };
}

    @Bean
    CommandLineRunner ChangerDateDebut(){
        return args -> {
            if (repositories.findByNumero_contrat(102L).isPresent()) {
                repositories.updateDate_debutByNumero_contrat(new Date(), 102L);
            }
        };
    }

    /*
    @Bean
    CommandLineRunner ChangerDateFin(){
        return args -> {
            if (repositories.findByNumero_contrat(102L).isPresent()) {
                repositories.updateDate_finByNumero_contrat(new Date(), 102L);
            }
        };
    }*/
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
    }
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
