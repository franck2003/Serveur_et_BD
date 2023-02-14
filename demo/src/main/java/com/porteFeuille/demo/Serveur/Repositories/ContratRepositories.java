package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.modèle.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface ContratRepositories extends JpaRepository<Contrat, Long>, JpaSpecificationExecutor<Contrat> {
    @Transactional
    @Modifying
    @Query("delete from Contrat c where c.numero_contrat = ?1")
    void deleteByNumero_contrat(@NonNull Long numero_contrat);
    @Query("select c from Contrat c where c.numero_contrat = ?1")
    Optional<Contrat> findByNumero_contrat(@NonNull Long numero_contrat);

}
