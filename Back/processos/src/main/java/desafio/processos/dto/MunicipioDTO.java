package desafio.processos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MunicipioDTO {

    private int id;
    private String nome;
    @JsonProperty("microrregiao")
    private MicroRegiao microRegiao;
    @JsonProperty("regiao-imediata")
    private RegiaoImediata regiaoimediata;

}

@Data
@AllArgsConstructor
class MicroRegiao{
    private int id;
    private String nome;
    @JsonProperty("mesorregiao")
    private MesoRegiao mesoRegiao;
}

@Data
@AllArgsConstructor
class MesoRegiao{
    private int id;
    private String nome;
    @JsonProperty("UF")
    private ufDTO uf;
}

@Data
@AllArgsConstructor
class RegiaoImediata{
    private int id;
    private String nome;
    @JsonProperty("regiao-intermediaria")
    private RegiaoIntermediaria regiaoIntermediaria;
}

@Data
@AllArgsConstructor
class RegiaoIntermediaria{
    private int id;
    private String nome;
    @JsonProperty("UF")
    private ufDTO uf;
}

