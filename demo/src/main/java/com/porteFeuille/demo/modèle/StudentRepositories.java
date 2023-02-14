package com.porteFeuille.demo.modèle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface StudentRepositories extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?1 where s.name = ?2")
    void updateNameByName(@NonNull String name, @NonNull String name1);


    @Transactional
    @Modifying
    @Query("delete from Student s where s.name = ?1")
    void deleteByName(@NonNull String name);

  

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    Optional<Student> findById(String name);





}
