package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface LoginRepositories  extends JpaRepository<Login, Long>, JpaSpecificationExecutor<Login> {
    @Query("select l from Login l where l.email = ?1")
    Optional<Login> findByEmail(@NonNull String email);
}
