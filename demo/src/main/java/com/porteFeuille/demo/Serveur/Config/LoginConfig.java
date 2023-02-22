package com.porteFeuille.demo.Serveur.Config;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import com.porteFeuille.demo.Serveur.Repositories.LoginRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Optional;
@Configuration
public class LoginConfig {
    @Bean
    CommandLineRunner nouveauCompte(LoginRepositories repositories){
        return args ->{
            Login l = new Login("francknjampou01@gmail.com", "franck2003");
            l.setMotDePasse(l.hashString(l.getMotDePasse()));
            if(repositories.findByEmail(l.getEmail()).isEmpty()){
                repositories.save(l);
            }
        };
    }
    @Bean
    CommandLineRunner recupererMotDePasse(LoginRepositories repositories){
        return args ->{
            Login login = new Login();
            Optional<Login> l = repositories.findByEmail("francknjampou@gmail.com");
            if(l.isPresent()){
                System.out.println(login.hashString(l.get().getMotDePasse()));
            }
            else {
                System.out.println("information erroné : va te branler et reessaie.conard");
            }
        };
    }
}
