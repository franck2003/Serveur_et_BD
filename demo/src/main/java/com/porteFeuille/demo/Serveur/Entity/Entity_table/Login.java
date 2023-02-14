package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    private String email;

    private String motDePasse;

    public Login() {
    }

    public Login(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }



    public String encription(String motDePasse, int index){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < motDePasse.length(); i++) {
            char letter = motDePasse.charAt(i);
            if (Character.isLetter(letter)) {
                if (Character.isUpperCase(letter)) {
                    s.append((char) ((letter + index - 65) % 26 + 65));
                } else {
                    s.append((char) ((letter + index - 97) % 26 + 97));
                }
            } else {
                System.out.println(motDePasse.charAt(i));
                int c = Integer.parseInt(String.valueOf(motDePasse.charAt(i)))+1;//
                System.out.println(c);
                s.append(c);

            }
        }
        return s.toString();
    }


    public String decription(String motDePasse, int index){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < motDePasse.length(); i++) {
            char letter = motDePasse.charAt(i);
            if (Character.isLetter(letter)) {
                if (Character.isUpperCase(letter)) {
                    s.append((char) ((letter - index - 65 + 26) % 26 + 65));
                } else {
                    s.append((char) ((letter - index - 97 + 26) % 26 + 97));
                }
            } else {
                s.append(motDePasse.charAt(i));

            }
        }
        return s.toString();
    }
}
