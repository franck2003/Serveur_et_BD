package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.PointFournitureRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointFournitureConfig {

    @Bean
    CommandLineRunner ajouterPointFourniture(PointFournitureRepositories repositories){
        return args ->{
            PointFourniture p = new PointFourniture(946430795197304526L, "gaz");
            repositories.save(p);
        };
    }

}
