package com.porteFeuille.demo.modèle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.NoSuchElementException;

@Configuration
public class StudentConfig {
// service, model , cob
    @Bean
    CommandLineRunner commandLineRunner( StudentRepositories repositories){

        return
                args -> { Student mariam = new Student( 30L, "bilal", 600, 10);

        if(repositories.findById(mariam.getName()).isEmpty()){
            repositories.save(mariam);
        }

    };
    }
    @Bean
    CommandLineRunner commandLineRunner1(StudentRepositories repositories){
        return
                args -> {
                    repositories.deleteByName("mamama");
                    System.out.println("ok");
                };
    }

    @Bean
    CommandLineRunner commandLineRunner2(StudentRepositories repositories){
        return
                args -> {
                    repositories.updateNameByName("alain", "mariam");
                    System.out.println("pappppppppppppp");
                };
    }
}
