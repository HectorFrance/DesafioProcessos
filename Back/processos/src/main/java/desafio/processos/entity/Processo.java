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
@Table(name ="processos")
public class Processo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "Npu")
    private String npu;

    @Column(name = "data_Cadastro")
    private LocalDate dataCadastro;

    @Column(name = "data_visualizacao")
    private LocalDate dataVisualizacao;

    @Column(name = "municipio")
    private long municipio;

    @Column(name = "estado")
    private long uf;

}
