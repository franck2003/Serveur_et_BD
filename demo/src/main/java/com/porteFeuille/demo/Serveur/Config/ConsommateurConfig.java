package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommateur;
import com.porteFeuille.demo.Serveur.Repositories.ConsommateurRepositories;
import com.porteFeuille.demo.Serveur.Repositories.ConsommationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

@Configuration
public class ConsommateurConfig {
    @Autowired
    ConsommateurRepositories consommateurRepositories;
   /*@Bean
    CommandLineRunner ajouterConsommateur(){
        return args -> {
            Consommateur consommateur = new Consommateur("njampou","franck", "francknjampou01@gmail.com");
            if(consommateur.getEmail().contains("@gmail.com")){
                try {
                    consommateurRepositories.save(consommateur);
                }catch (DataIntegrityViolationException e){
                    System.out.println("données presente");

                }
            }
            else{
                System.out.println("veillez saisir une adresse valide svp");
            }
        };
    }*/
}
