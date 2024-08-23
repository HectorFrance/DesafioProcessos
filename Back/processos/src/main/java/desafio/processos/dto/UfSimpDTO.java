package desafio.processos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UfSimpDTO {

    private int id;
    private String sigla;
    private String nome;
}
