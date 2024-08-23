package desafio.processos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ufIBGEDTO {
    private int id;
    private String sigla;
    private String nome;
    private Regiao regiao;

    public String nomeUf() {
        return getNome();
    }

}

@Data
@AllArgsConstructor
class Regiao {

    private int id;
    private String sigla;
    private String nome;

}