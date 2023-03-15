package com.porteFeuille.demo.Serveur.Config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;
import org.json.JSONObject;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Notification;
import com.porteFeuille.demo.Serveur.Repositories.NotificationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Date;
import java.util.List;

@Configuration
public class NotificationConfig {

    @Autowired
    NotificationRepositories repositories;
    /*@Bean
    CommandLineRunner ajouterNotification() throws JsonProcessingException {
        return args -> {
            Fournisseur fournisseur = new Fournisseur(52L);
            ObjectMapper mapper = new ObjectMapper();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put( "bonjout", 50);
            jsonObject.put("age", "bonjour");
            String json = jsonObject.toString();
            System.out.println(json);
            Notification notification = new Notification(fournisseur, new Date(),"traité",json);

        repositories.save(notification);

        };
    }*/

}
