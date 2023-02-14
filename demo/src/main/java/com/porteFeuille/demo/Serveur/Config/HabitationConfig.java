package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.HabitationRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HabitationConfig {
    @Bean
    CommandLineRunner ajouterHabitation(HabitationRepositories repositories){
        return args ->{
            Adresse adresse = new Adresse("roiAlbert",642,"maison","Mons",7012);
            Habitation c = new Habitation(165444L,165416541651L,adresse.toString());
            if (repositories.findByHabitationId(c.getHabitationId()).isEmpty()){
                repositories.save(c);
            }
        };
    }
}
