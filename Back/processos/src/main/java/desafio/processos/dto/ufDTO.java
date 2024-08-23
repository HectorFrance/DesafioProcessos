package desafio.processos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ufDTO {
    private int id;
    private String sigla;
    private String nome;
    private Regiao regiao;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Regiao {

    private int id;
    private String sigla;
    private String nome;

}