package com.porteFeuille.demo.Service;

import com.porteFeuille.demo.Controller.CustomUserDetails;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Repositories.FournisseurRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private FournisseurRepositories fournisseurRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Fournisseur fournisseur = fournisseurRepositories.findByEmail(username);
        if(fournisseur == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(fournisseur);
    }
}
