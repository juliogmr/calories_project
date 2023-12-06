package com.br.myprojects.foods.infraestructure.persistence;

import com.br.myprojects.foods.domain.entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodsRepository extends JpaRepository<Foods, Long> {

    Optional<Foods> findByDescricao(String nome);

    @Query("select e from Foods e")
    List<Foods> findAll();
}
