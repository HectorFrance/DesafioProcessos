package desafio.processos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UfDTO {
    private long id;
    private String sigla;
    private String nome;
    private Regiao regiao;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Regiao {

    private long id;
    private String sigla;
    private String nome;

}