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

    @RequestMapping("/Style2")
    public String s(){
        return "Style2";
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

    @RequestMapping("CreateWallet")
    public String createWallet(){
        return "CreateWallet";
    }

    /*

    <form action="/bienvenu" method="POST">
    <h2>Login</h2>
    <form>
        <label for="email">Email :</label>
        <input type="email" id="email" name="email" placeholder="Entrez votre adresse email">

        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="motDePasse" placeholder="Entrez votre mot de passe" oninput="maskPassword()">

    </form>
    <div>
        <button type="submit" onclick="sendLogin()">Login</button>
        <script>
            function sendLogin() {
                var emailInput = document.getElementById("email").value;
                var passwordInput = document.getElementById("password").value;
                var login = {email: emailInput, motDePasse: passwordInput};
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "/bienvenu");
                xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                xhr.send(JSON.stringify(login));
            }

            function maskPassword() {
                var passwordInput = document.getElementById("password");
                var maskedPassword = "";
                for (var i = 0; i < passwordInput.value.length; i++) {
                    maskedPassword += "*"; // remplacer par un point pour un masquage plus visuel (•)
                }
                passwordInput.value = maskedPassword;
            }
        </script>
    </div>
</form>


     */


}
