package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommation;
import com.porteFeuille.demo.Serveur.Repositories.ConsommationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;


@Configuration
public class ConsommationConfig{
    @Autowired
    ConsommationRepositories repositories;

    @Bean
    CommandLineRunner ajouterDonneesDeConsommation(){
        return args ->{
            Date dateDebut = new Date();

            Date dateFin = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 1);
            dateFin.setTime(calendar.getTimeInMillis());
            Consommation c = new Consommation(165416154L, 16578415L, 0, new Date());
            if (repositories.findByHabitation_idAndEan(c.getHabitation_id(), c.getEan()).isEmpty()) {
                repositories.save(c);
            }
        };
    }
}
/*
est ce que a chaque fin du mois je dois save la meme habitation et reset la valeur a 0
 */