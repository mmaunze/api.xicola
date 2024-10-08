package mz.co.mefemasys.xicola.backend.models.dto;

import mz.co.mefemasys.xicola.backend.models.Documento;
import java.time.Instant;
import lombok.Data;

@Data
public class DocumentoDTO {

    private Long id;
    private String titulo;
    private String tipoDocumento;
    private String conteudo;
    private Instant dataCriacao;
    private Long autor;
    private String estado;

    public DocumentoDTO(Documento documento) {
        this.id = documento.getId();
        this.titulo = documento.getTitulo();
        this.tipoDocumento = documento.getTipoDocumento().getDescricao();
        this.conteudo = documento.getConteudo();
        this.dataCriacao = documento.getDataCriacao();
        this.autor = documento.getAutor().getId();
        this.estado = documento.getEstado().getDescricao();
    }
}
