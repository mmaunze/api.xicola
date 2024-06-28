package com.xicola.xicola.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xicola.xicola.model.Veiculo;

/**
 * Repositório JPA para a entidade Veiculo.
 */
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT v FROM Veiculo v WHERE v.estado.id = :estado")
    List<Veiculo> findByEstadoId(Long estado);

}
