package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommateur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ConsommateurRepositories extends JpaRepository<Consommateur, Long>, JpaSpecificationExecutor<Consommateur> {
    @Query("select c from Consommateur c where c.Email = ?1")
    Optional<Consommateur> findByEmail(@NonNull String Email);
}
