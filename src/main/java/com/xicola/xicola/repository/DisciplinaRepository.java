package com.xicola.xicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xicola.xicola.model.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    @Query("SELECT d FROM Disciplina d WHERE d.nomeDisciplina = :nomeDisciplina")
    Optional<Disciplina> findDisciplina(@Param("nomeDisciplina") String nomeDisciplina);

}
