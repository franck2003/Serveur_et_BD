package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface FournisseurRepositories extends JpaRepository<Fournisseur, Long>, JpaSpecificationExecutor<Fournisseur> {
    @Query("select f from Fournisseur f where f.email = ?1")
    Fournisseur findByEmail(String email);
    @Transactional
    @Modifying
    @Query("delete from Fournisseur f where f.nom_fournisseur = ?1")
    void deleteByNom_fournisseur(@NonNull String nom_fournisseur);
    @Query("select f from Fournisseur f where f.nom_fournisseur = ?1")
    Optional<Fournisseur> findByNom_fournisseur(@NonNull String nom_fournisseur);

}
