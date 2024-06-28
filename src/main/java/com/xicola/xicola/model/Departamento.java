package com.xicola.xicola.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "departamento", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "departamento_descricao_key", columnNames = {"descricao"}),
        @UniqueConstraint(name = "departamento_sigla_key", columnNames = {"sigla"})
})
public class Departamento {
    @Id

    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Size(max = 10)
    @NotNull
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

}