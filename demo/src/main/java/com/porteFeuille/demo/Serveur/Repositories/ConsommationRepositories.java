package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Consommation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ConsommationRepositories  extends JpaRepository<Consommation, Long>, JpaSpecificationExecutor<Consommation> {
    @Query("select c from Consommation c where c.pointFournitureId = ?1 and c.habitationId = ?2")
    Optional<Consommation> findByPointFournitureIdAndHabitationId(PointFourniture pointFournitureId, Habitation habitationId);



}
