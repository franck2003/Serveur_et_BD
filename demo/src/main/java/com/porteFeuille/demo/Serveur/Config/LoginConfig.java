package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import com.porteFeuille.demo.Serveur.Repositories.LoginRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
@Configuration
public class LoginConfig {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner nouveauCompte(LoginRepositories repositories){
        return args ->{
            Login l = new Login("hemin@gmail.com", "mamamam");
            l.setMotDePasse(passwordEncoder.encode(l.getMotDePasse()));
            if(repositories.findByEmail(l.getEmail()).isEmpty()){
                repositories.save(l);
            }
        };
    }
    /*
    @Bean
    CommandLineRunner exist(LoginRepositories repositories){
        return args ->{
            String email = "hemin@gmail.com";
            String motDePasse = "mamamam";
            Optional<Login> login = repositories.findByEmail(email);
            if(login.isPresent()){
                if(passwordEncoder.matches(motDePasse, login.get().getMotDePasse())){
                    System.out.println("L'utilisateur est authentifié !");
                }
                else {
                    System.out.println("Le mot de passe est incorrect.");
                }
            }
            else {
                System.out.println("L'email n'existe pas dans la base de données.");
            }
        };
    }*/
}
