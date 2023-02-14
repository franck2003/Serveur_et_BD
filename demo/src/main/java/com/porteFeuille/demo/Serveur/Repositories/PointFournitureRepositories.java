package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface PointFournitureRepositories extends JpaRepository<PointFourniture, Long>, JpaSpecificationExecutor<PointFourniture> {
    @Query("select p from PointFourniture p where p.fourniture = ?1")
    Optional<PointFourniture> findByNom_fournisseur(@NonNull String fourniture);
}
