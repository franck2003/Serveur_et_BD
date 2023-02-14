package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacturationRepositories extends JpaRepository<Contrat, Long>, JpaSpecificationExecutor<Contrat> {
}
