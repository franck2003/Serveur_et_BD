package com.porteFeuille.demo.Controller;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommateur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    Fournisseur fournisseur;
    Consommateur consommateur;
    public CustomUserDetails(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }public CustomUserDetails(Consommateur c){
        this.consommateur = c;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getFullName(){
        return fournisseur.getNom_fournisseur()+ " " + fournisseur.getEmail();
    }
}
