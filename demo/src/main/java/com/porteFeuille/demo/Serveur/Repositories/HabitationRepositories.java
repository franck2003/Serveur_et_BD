package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Habitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface HabitationRepositories extends JpaRepository<Habitation, Long>, JpaSpecificationExecutor<Habitation> {
    @Query("select c from Habitation c where c.habitationId = ?1")
    Optional<Habitation> findByHabitationId(@NonNull Long habitationId);
}
