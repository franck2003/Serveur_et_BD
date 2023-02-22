package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class LoginFournisseur {
    @Id
    private String email;

    private String motDePasse;
    @Transient
    private String nouveauMotdePasse;

    public LoginFournisseur() {
    }

    public LoginFournisseur(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public LoginFournisseur(String email, String motDePasse, String nouveauMotdePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.nouveauMotdePasse = nouveauMotdePasse;
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

    public String getNouveauMotdePasse() {
        return nouveauMotdePasse;
    }

    public void setNouveauMotdePasse(String nouveauMotdePasse) {
        this.nouveauMotdePasse = nouveauMotdePasse;
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
                int c = Integer.parseInt(String.valueOf(letter))+index;
                s.append(c);

            }
        }
        System.out.println(s);
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
                int c = Integer.parseInt(String.valueOf(letter))-index;
                s.append(c);
            }
        }
        System.out.println(s);
        return s.toString();
    }
}
