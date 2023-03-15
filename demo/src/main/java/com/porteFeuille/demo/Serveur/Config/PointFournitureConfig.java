package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.PointFournitureRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PointFournitureConfig {
    @Bean
    CommandLineRunner ajouterPointFourniture(PointFournitureRepositories repositories){
        return args ->{
            List<PointFourniture> list = new ArrayList<>();
            PointFourniture gaz = new PointFourniture(946430795197304526L, "gaz");
            PointFourniture eau = new PointFourniture(794929267075728442L, "eau");
            PointFourniture electricite = new PointFourniture(803429457858963427L, "électricité");
            list.add(gaz);
            list.add(eau);
            list.add(electricite);
            try {
                repositories.saveAll(list);
            }catch (DataIntegrityViolationException e){
                System.out.println("l'information que vous voulez ajouter dans la base de données est deja presente");
            }
        };
    }

}
