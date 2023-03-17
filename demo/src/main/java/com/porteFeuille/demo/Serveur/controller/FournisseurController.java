package com.porteFeuille.demo.Serveur.controller;

import  com.porteFeuille.demo.Serveur.service.*;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@RestController
@CrossOrigin
public class FournisseurController {


    @Autowired
    private FournisseurService fournisseurService;
    @GetMapping("/getf")
    public Iterable<Fournisseur> getFournisseur(){
        return fournisseurService.getFournisseurs();
    }

  //  @GetMapping("/get")
    //public Optional<Fournisseur> getFournisseur(String name) {
      //  return fournisseurService.getFournisseur(name);

    //}
    @PostMapping("/postF")
    public String addFournisseur(@RequestParam String nom_fournisseur, @RequestParam String siege, @RequestParam String email) {
        Fournisseur fournisseur = new Fournisseur(nom_fournisseur, null,null, email);
        fournisseurService.saveFournisseur(fournisseur);
        return "New Fournisseur added";
    }

    @PostMapping("postt")
    public void addFourn(){
        Fournisseur f1 = new Fournisseur("Mkghoh", null, null, "jhgv");
        fournisseurService.saveFournisseur(f1);
    }

}
