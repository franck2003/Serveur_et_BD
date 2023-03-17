package com.porteFeuille.demo.Serveur.service;
import java.util.Optional;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;

@Data
@Service
@CrossOrigin
public class FournisseurService {


    @Autowired
    private FournisseurRepositories fournisseurRepository;

    public FournisseurService(FournisseurRepositories repository) {
        this.fournisseurRepository = repository;
    }

    //@Query("select * from fournisseur")
    //public Optional<Fournisseur> getFournisseur(final String name) {
        //return fournisseurRepository.findById(name);
    //}


   // public void deleteFournisseur(final String name) {
        //fournisseurRepository.deleteById(name);
   // }

    public Fournisseur saveFournisseur(@RequestBody Fournisseur fournisseur){
        Fournisseur savedFournisseur = fournisseurRepository.save(fournisseur);
        return savedFournisseur;
    }

    public Iterable<Fournisseur> getFournisseurs(){
        return fournisseurRepository.findAll();
    }
}
