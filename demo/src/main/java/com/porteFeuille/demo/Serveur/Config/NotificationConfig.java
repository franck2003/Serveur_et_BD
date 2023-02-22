package com.porteFeuille.demo.Serveur.Config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Notification;
import com.porteFeuille.demo.Serveur.Repositories.NotificationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Autowired
    NotificationRepositories repositories;

    @Bean
    CommandLineRunner ajouterNotification() throws JsonProcessingException {
        return args -> {
            Fournisseur fournisseur = new Fournisseur(52L);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString("je souhaite ouvrir un contrat");

        Notification notification = new Notification(fournisseur, "pas traité",json);

        repositories.save(notification);

        };
    }
}
