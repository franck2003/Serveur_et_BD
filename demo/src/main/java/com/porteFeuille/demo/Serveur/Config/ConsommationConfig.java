package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommation;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Repositories.ConsommationRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsommationConfig{

    @Bean
    CommandLineRunner ajouterDonneesDeConsommation(ConsommationRepositories repositories){
        return args ->{
            Date date = new Date(1, 15, 12);
            Consommation c = new Consommation(165416154L, 16578415L, date.toString(), 1542);
            if (repositories.findByHabitation_idAndEan(c.getHabitation_id(), c.getEan()).isEmpty()) {
                repositories.save(c);
            }
        };
    }
}
