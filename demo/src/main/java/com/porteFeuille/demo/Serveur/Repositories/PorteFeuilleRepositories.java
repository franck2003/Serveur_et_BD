package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.PointFourniture;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.PorteFeuille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PorteFeuilleRepositories extends JpaRepository<PorteFeuille, Long>, JpaSpecificationExecutor<PorteFeuille> {
}
