package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.*;
import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import com.porteFeuille.demo.Serveur.Repositories.HabitationRepositories;
import com.porteFeuille.demo.Serveur.Repositories.PorteFeuilleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;


@Configuration

public class PorteFeuilleConfig {

    @Autowired
    PorteFeuilleRepositories porteFeuilleRepositories;

    @Bean
    CommandLineRunner ajouterPorteFeuille(){
        return args ->{
            Consommateur consommateur = new Consommateur(2L);
            Habitation habitation = new Habitation(1252L);
            PorteFeuille porteFeuille = new PorteFeuille(consommateur, habitation);
            try {
                porteFeuilleRepositories.save(porteFeuille);
            }catch (DataIntegrityViolationException e){
                //System.out.println("données presente");

            }
        };
    }
}
