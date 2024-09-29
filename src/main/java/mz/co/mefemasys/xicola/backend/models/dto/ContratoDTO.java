package mz.co.mefemasys.xicola.backend.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import mz.co.mefemasys.xicola.backend.models.Contrato;

import lombok.Data;

@Data
public class ContratoDTO {
    private Long id;
    private String nome;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;
    private String fornecedor;
    private Long responsavel;
    private String estado;

    public ContratoDTO(Contrato contrato) {
        this.id = contrato.getId();
        this.nome = contrato.getDescricao();
        this.tipo = contrato.getTipo();
        this.dataInicio = contrato.getDataInicio();
        this.dataFim = contrato.getDataFim();
        this.valorTotal = contrato.getValorTotal();
        this.fornecedor = contrato.getFornecedor();
        this.responsavel = contrato.getResponsavel().getId();
        this.estado = contrato.getEstado().getDescricao();
    }
}
