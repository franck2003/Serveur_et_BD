package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Fournisseur;
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
            where c.client_id = ?2 and c.ean = ?3 and c.fournisseur_id = ?4 and c.compteur = ?5""")
    int updateCompteurByClient_idAndEanAndFournisseur_idAndCompteur(String compteur, Long client_id, PointFourniture ean, Fournisseur fournisseur_id, String compteur1);
    @Transactional
    @Modifying
    @Query("update Contrat c set c.date_fin = ?1 where c.numero_contrat = ?2")
    void updateDate_finByNumero_contrat(@NonNull Date date_fin, Long numero_contrat);
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
