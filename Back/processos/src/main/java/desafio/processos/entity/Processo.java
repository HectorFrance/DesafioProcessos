package desafio.processos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of ="id")


@Entity
@Table(name ="tb_processos")
public class Processo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String npu;

    private LocalDate dataCadatro;

    private LocalDate dataVisualizacao;

    private String municipio;

    private String uf;

}
