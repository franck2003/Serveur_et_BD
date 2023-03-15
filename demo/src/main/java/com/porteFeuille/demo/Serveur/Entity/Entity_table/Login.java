package com.porteFeuille.demo.Serveur.Entity.Entity_table;

import jakarta.persistence.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    private String email;

    private String motDePasse;
    @Transient
    private String nouveauMotdePasse;

    public Login() {
    }

    public Login(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Login(String email, String motDePasse, String nouveauMotdePasse) {
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
        this.motDePasse = nouveauMotdePasse;
    }
    /*
    public String encription(String motDePasse) throws Exception {
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryp = cipher.doFinal(motDePasse.getBytes());
        return new String(encryp);
    }

    public String decription(String motDePasse) throws Exception{
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(motDePasse.getBytes());
        return new String(decrypted);
    }*/
    public String hashString(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

