package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import com.porteFeuille.demo.Serveur.Entity.Object.Adresse;
import com.porteFeuille.demo.Serveur.Repositories.ContratRepositories;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@Configuration
public class FournisseurConfig {

    @Autowired
    FournisseurRepositories repositories;
/*
    @Bean
    CommandLineRunner ajouterClient(){
        return args ->{
            Adresse s = new Adresse("DuFord",31,"null","Mons",7012);
            PointFourniture pointFourniture = new PointFourniture(102L);
            Long cout = 2L;
            Fournisseur fournisseur = new Fournisseur("lampiris", pointFourniture, s.toString(),"lampiris@gmail.com",2L);
            try {
                repositories.save(fournisseur);
            }catch (DataIntegrityViolationException e){
                System.out.println("données existe dans la BD");
            }
        };
    }*/
/*
    @Bean
    CommandLineRunner supprimerClient(){
        return args ->{
            Adresse s = new Adresse("DuFord",31,"null","Mons",7012);
            /*
                changer l'objet Fournisseur en Consommateur
            */
    /*
            Fournisseur fournisseur = new Fournisseur("proximus", s.toString(), "proximus@gmail.com");
            if (repositories.findByNom_fournisseur (fournisseur.getNom_fournisseur()).isPresent()){
                repositories.deleteByNom_fournisseur(fournisseur.getNom_fournisseur());
            }
        };
    }


@Bean
CommandLineRunner recupererEmailFournisseur(){
    return args ->{
        Optional<Fournisseur> op  = repositories.findByNom_fournisseur("proximus");
        if (op.isPresent()) {
            //System.out.println(op.get().getEmail());
        } else {
            //System.out.println("Aucun élément trouvé avec l'ID : " + "proximus");
        }
    };
}
*/
}
