package desafio.processos.dto;

import desafio.processos.dto.ufDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MunicipioDTO {

    private int id;
    private String nome;
    private MicroRegiao mircoRegiao;
    private RegiaoImediata regiaoImediata;

}

@Data
@AllArgsConstructor
class MicroRegiao{
    private int id;
    private String nome;
    private MesoRegiao mesoRegiao;
}

@Data
@AllArgsConstructor
class MesoRegiao{
    private int id;
    private String nome;
    private ufDTO uf;
}

@Data
@AllArgsConstructor
class RegiaoImediata{
    private int id;
    private String nome;
    private RegiaoIntermediaria regiaoIntermediaria;
}

@Data
@AllArgsConstructor
class RegiaoIntermediaria{
    private int id;
    private String nome;
    private ufDTO uf;
}