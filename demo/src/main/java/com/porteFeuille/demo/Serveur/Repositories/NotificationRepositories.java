package com.porteFeuille.demo.Serveur.Repositories;

import com.porteFeuille.demo.Serveur.Entity.Entity_table.Login;
import com.porteFeuille.demo.Serveur.Entity.Entity_table.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationRepositories extends JpaRepository<Notification, Long>, JpaSpecificationExecutor<Notification> {
}
