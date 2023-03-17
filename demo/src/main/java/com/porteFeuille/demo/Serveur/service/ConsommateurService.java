package com.porteFeuille.demo.Serveur.service;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommateur;
import com.porteFeuille.demo.Serveur.Repositories.ConsommateurRepositories;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@Data

public class ConsommateurService {

    @Autowired
    private ConsommateurRepositories consommateurRepository;

    public Iterable<Consommateur> getConsos(){
        return consommateurRepository.findAll();
    }

    public Optional<Consommateur> getConsommateur(Long id){
        return consommateurRepository.findById(id);
    }

    public void deleteConso(Long id){
        consommateurRepository.deleteById(id);
    }

    public Consommateur saveConso(@RequestBody Consommateur consommateur){
        Consommateur consommateur1 = consommateurRepository.save(consommateur);
        return consommateur1;
    }
}
