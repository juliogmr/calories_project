package com.br.myprojects.activities.infraestructure.persistence;

import com.br.myprojects.activities.domain.entity.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activities, Long> {

    Optional<Activities> findByNome(String nome);

    @Query("select e from Activities e")
    List<Activities> findAll();
}
