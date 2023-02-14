package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Object.Date;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.modèle.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
@Configuration
public class ContratConfig {

    @Bean
    CommandLineRunner ajouterContrat(ContratRepositories repositories){
        return args ->{
            Date date_first = new Date(1,7,2003);
            Date date_second = new Date(1,8,2006);
            Contrat contrat = new Contrat(15L, 187L,"proximus" , 487L,date_first.toString(),date_second.toString());
            if (repositories.findByNumero_contrat(contrat.getNumero_contrat()).isEmpty()) {
                repositories.save(contrat);
            }
        };
    }


    @Bean
    CommandLineRunner suppimerContrat(ContratRepositories repositories){
        return args -> {
            if (repositories.findByNumero_contrat(102L).isPresent()) {
                repositories.deleteByNumero_contrat(102L);
            }
    };
}

    @Bean
    CommandLineRunner ChangerDateDebut(ContratRepositories repositories){
        return args -> {
            if (repositories.findByNumero_contrat(102L).isPresent()) {
                //repositories.update;(ici je demanderai au prof)
            }
        };
    }

    @Bean
    CommandLineRunner ChangerDateFin(ContratRepositories repositories){
        return args -> {
            if (repositories.findByNumero_contrat(102L).isPresent()) {
                //repositories.update;(ici je demanderai au prof)
            }
        };
    }
}
