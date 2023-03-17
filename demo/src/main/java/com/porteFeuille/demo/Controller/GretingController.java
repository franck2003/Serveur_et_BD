package com.porteFeuille.demo.Controller;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;
import com.porteFeuille.demo.Serveur.Repositories.LoginRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping

public class GretingController {
    @Autowired
    LoginRepositories loginRepositories;

    @Autowired
    private FournisseurRepositories fournisseurRepositories;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello from our application");
    }

    @GetMapping("/welcome")
    public String sayGoodBye(){
        return "login";
    }

    @GetMapping("/fournisseur")
    public List<Fournisseur> listUsers() {
        List<Fournisseur> listUsers = fournisseurRepositories.findAll();
        return listUsers;
    }

    @GetMapping("/user")
    public List<Login> getUser(){
        return loginRepositories.findAll();
    }

}
