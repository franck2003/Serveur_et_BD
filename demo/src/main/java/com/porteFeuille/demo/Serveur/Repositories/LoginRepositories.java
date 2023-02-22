package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface LoginRepositories  extends JpaRepository<Login, Long>, JpaSpecificationExecutor<Login> {
    @Transactional
    @Modifying
    @Query("update Login l set l.motDePasse = ?1 where l.email = ?2")
    void updateMotDePasseByEmail(@NonNull String motDePasse, @NonNull String email);
    @Query("select l from Login l where l.email = ?1 and l.motDePasse = ?2")
    Optional<Login> findByEmailAndMotDePasse(@NonNull String email, String motDePasse);

    @Query("select l from Login l where l.email = ?1")
    Optional<Login> findByEmail(@NonNull String email);

}
