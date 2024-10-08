package mz.co.mefemasys.xicola.backend.models.dto;

import mz.co.mefemasys.xicola.backend.models.AvaliacaoAluno;
import java.io.Serializable;
import java.time.Instant;
import lombok.Data;

@Data
public class AvaliacaoAlunoDTO implements Serializable {
    private Long id;
    private Long aluno;
    private Long avaliacao;
    private Integer trimestre;
    private Integer anoLectivo;
    private Instant dataLancamento;
    private Double nota;
    private String observacao;
    private String estado;

    public AvaliacaoAlunoDTO() {
    }

    public AvaliacaoAlunoDTO(AvaliacaoAluno avaliacaoAluno) {
        this.id = avaliacaoAluno.getId();
        this.aluno = avaliacaoAluno.getAluno().getId();
        this.trimestre = avaliacaoAluno.getTrimestre();
        this.anoLectivo = avaliacaoAluno.getAnoLectivo();
        this.dataLancamento = avaliacaoAluno.getDataLancamento();
        this.nota = avaliacaoAluno.getNota();
        this.observacao = avaliacaoAluno.getObservacao();
        this.avaliacao = avaliacaoAluno.getAvaliacao().getId();
        this.estado = avaliacaoAluno.getEstado().getDescricao();
    }
}
