package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
@Repository
public interface ContratRepositories extends JpaRepository<Contrat, Long>, JpaSpecificationExecutor<Contrat> {
    @Transactional
    @Modifying
    @Query("""
            update Contrat c set c.compteur = ?1
            where c.compteur = ?2 and c.habitationId = ?3 and c.pointFournitureId = ?4""")
    void updateCompteurByCompteurAndHabitationIdAndPointFournitureId(String compteur, @NonNull String compteur1, @NonNull Habitation habitationId, @NonNull PointFourniture pointFournitureId);
    @Transactional
    @Modifying
    @Query("update Contrat c set c.date_debut = ?1 where c.numero_contrat = ?2")
    void updateDate_debutByNumero_contrat(@NonNull Date date_debut, long l);
    @Transactional
    @Modifying
    @Query("delete from Contrat c where c.numero_contrat = ?1")
    void deleteByNumero_contrat(@NonNull Long numero_contrat);
    @Query("select c from Contrat c where c.numero_contrat = ?1")
    Optional<Contrat> findByNumero_contrat(@NonNull Long numero_contrat);


}
