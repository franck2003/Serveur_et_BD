package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface HabitationRepositories extends JpaRepository<Habitation, Long>, JpaSpecificationExecutor<Habitation> {
    @Query("select h from Habitation h where h.habitationId = ?1")
    Optional<Habitation> findByHabitationId(Long habitationId);
    @Query("select h from Habitation h where h.adresse = ?1 and h.pointFournitureId = ?2")
    Habitation findByAdresseAndPointFournitureId(@NonNull String adresse, PointFourniture pointFournitureId);

}
