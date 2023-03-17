package com.porteFeuille.demo.Controller;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import com.porteFeuille.demo.Serveur.Repositories.LoginRepositories;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Controller
public class myController implements WebMvcConfigurer {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LoginRepositories loginRepositories;

   // public void addRessourceHandlers(ResourceHandlerRegistry registry){
     //   registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
   // }
    @RequestMapping("/SignIn")
    public String submitForm(){
        return "SignIn";
    }

    @GetMapping("/bienvenu")
    public String bienvenu(@RequestParam(value = "username", required = false) String username,
                                           @RequestParam(value = "password", required = false) String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("monsieur");
        if (username == null || password == null) {
            return "bienvenu";
        }
        Optional<Login> tmp = loginRepositories.findByEmail(username);
        if (tmp.isPresent()) {
            System.out.println("bonjour");
            System.out.println("bonjour");
            boolean bool = passwordEncoder.matches(tmp.get().getMotDePasse(), password);
            if (bool){
                return "bienvenu";
            }
        }
        return "bienvenu";
    }
    @GetMapping("/register")
    public ResponseEntity<String> register(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password", required = false) String password) {

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Les paramètres 'username' et 'password' sont requis.");
        }
        System.out.println(username);
        System.out.println(password);
        password = passwordEncoder.encode(password);
        Login login = new Login(username, password);
        loginRepositories.save(login);
        // Traitez les données de l'utilisateur ici
        return ResponseEntity.ok("enregistrer avec succes");
    }


}
