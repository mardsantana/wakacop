package academy.wakanda.wakacop.pauta.app.domain;

import academy.wakanda.wakacop.pauta.app.api.NovaPautaRequest;
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
    @Column(name = "id_associado_autor")
    private UUID idAssociadoAutor;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public Pauta(NovaPautaRequest novaPauta) {
        this.titulo = novaPauta.getTitulo();
        this.descricao = novaPauta.getDescricao();
        this.idAssociadoAutor = novaPauta.getIdAssociadoAutor();
        this.dataCriacao = LocalDateTime.now();
    }
}
