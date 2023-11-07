package academy.wakanda.wakacop.domain;

import academy.wakanda.wakacop.api.NovaPautaRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String titulo;
    private String descricao;
    private UUID idAssociadoAutor;
    private LocalDateTime dataCriacao;

    public Pauta(NovaPautaRequest novaPauta) {
        this.titulo = novaPauta.getTitulo();
        this.descricao = novaPauta.getDescricao();
        this.idAssociadoAutor = novaPauta.getIdAssociadoAutor();
        this.dataCriacao = LocalDateTime.now();
    }
}
