package com.porteFeuille.demo.Serveur.controller;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommateur;
import com.porteFeuille.demo.Serveur.service.ConsommateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
public class ConsommateurController {
    @Autowired
    private ConsommateurService consommateurService;

    @GetMapping("/getConsos")
    public Iterable<Consommateur> getConsommateurs(){
        return consommateurService.getConsos();
    }

    @GetMapping("/getConso")
    public Optional<Consommateur> getConsommateur(Long id){
        return consommateurService.getConsommateur(id);
    }

    @PostMapping("/postConso")
    public String postConso(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String mdp){
        Consommateur consommateur = new Consommateur(nom, prenom, email);
        consommateurService.saveConso(consommateur);
        return "New Conso added !";
    }

}
