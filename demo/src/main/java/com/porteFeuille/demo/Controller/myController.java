package com.porteFeuille.demo.Controller;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommateur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import com.porteFeuille.demo.Serveur.Repositories.ConsommateurRepositories;
import com.porteFeuille.demo.Serveur.Repositories.LoginRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    private ConsommateurRepositories consommateurRepositories;

    @Autowired
    private  LoginRepositories loginRepositories;

   // public void addRessourceHandlers(ResourceHandlerRegistry registry){
     //   registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
   // }
    @RequestMapping("/SignIn")
    public String submitForm(){
        return "SignIn";
    }

    @RequestMapping("/Style2")
    public String s(){
        return "Style2";
    }

    @GetMapping("/Style2.css")
    public ResponseEntity<Resource> getPageCss(){
        Resource resource = new ClassPathResource("/static/css/Style2.css");
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("text/css")).body(resource);
    }

    @GetMapping("/bienvenu")
    public String bienvenu(@RequestParam(value = "username") String username,
                                           @RequestParam(value = "password") String password) {
        System.out.println(username);
        System.out.println(password);
        if (username == null || password == null) {
            System.out.println("monsieur");
            return "Home";
        }
        Optional<Login> tmp = loginRepositories.findByEmail(username);
        if (tmp.isPresent()) {
            System.out.println("bonjour");
            System.out.println("bonjour");
            boolean bool = passwordEncoder.matches(password, tmp.get().getMotDePasse());
            if (bool){
                System.out.println("merci");
                return "Home";
            }
        }
        System.out.println("aurevoir");
        return "Home";
    }
    /*@GetMapping("/register")
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
    }*/
    @PostMapping("/process_register")
    public String processRegister(@Validated Consommateur consommateur, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "error";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(consommateur.getMotDePasse());
        consommateur.setMotDePasse(password);
        System.out.println(consommateur.getEmail());

        loginRepositories.save(new Login(consommateur.getEmail(), consommateur.getMotDePasse()));
        consommateurRepositories.save(consommateur);

        return "login";
    }

    @PostMapping("/register")
    public String Register(@Validated Login login, BindingResult result, Model model) {

        Optional<Login> tmp = loginRepositories.findByEmail(login.getEmail());
        if (tmp.isPresent()) {
            System.out.println("bonjour");
            System.out.println("bonjour");
            boolean bool = passwordEncoder.matches(login.getMotDePasse(), tmp.get().getMotDePasse());
            if (bool){
                System.out.println("merci");
                return "Home";
            }
        }
        System.out.println("aurevoir");
        return "error";
    }
    @GetMapping("/SignUp")
    public String showRegistrationForm(Model model) {
        model.addAttribute("consommateur", new Consommateur());

        return "signUp";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    //

    @GetMapping("CreateWallet")
    public String createWallet(){
        return "CreateWallet";
    }

    @GetMapping("ManageWallet")
    public String ManageWallet(){
        return "ManageWallet";
    }
/*
    @GetMapping("ManageWallet")
    public String ManageWallet(){
        return "ManageWallet";
    }

    @GetMapping("ManageWallet")
    public String ManageWallet(){
        return "ManageWallet";
    }

    @GetMapping("ManageWallet")
    public String ManageWallet(){
        return "ManageWallet";
    }
*/


}
