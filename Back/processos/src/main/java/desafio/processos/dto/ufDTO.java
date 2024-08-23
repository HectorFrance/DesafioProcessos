package desafio.processos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ufDTO {
    private int id;
    private String sigla;
    private String nome;
    private Regiao regiao;

}

@Data
@AllArgsConstructor
class Regiao {

    private int id;
    private String sigla;
    private String nome;

}