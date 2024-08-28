package desafio.processos.dto;

import desafio.processos.controller.MunicipioController;
import desafio.processos.controller.UfController;
import desafio.processos.entity.Processo;
import desafio.processos.service.ProcessoService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProcessoDTO {

    private Long id;

    private String npu;

    private LocalDate dataCadastro;

    private LocalDate dataVisualizacao;

    private String municipio;

    private  String uf;

    private Long municipioId;

    private  Long ufId;



    public ProcessoDTO(Processo p, MunicipioController mc, UfController uc){
        MunicipioDTO municipioDTO= mc.consultarMunicipioPorID(p.getMunicipio()).getBody();
        UfDTO ufDTO= uc.consultarUfPorId(p.getUf()).getBody();
        this.id=p.getId();
        this.npu=p.getNpu();
        this.dataCadastro=p.getDataCadastro();
        this.dataVisualizacao=p.getDataVisualizacao();
        this.uf=ufDTO.getNome();
        this.ufId=ufDTO.getId();
        this.municipio=municipioDTO.getNome();
        this.municipioId=municipioDTO.getId();

    }


    public List<ProcessoDTO> transformarLista(List<Processo> lp, MunicipioController mc, UfController uc){
        List<ProcessoDTO> listaProcessoDTO = new ArrayList<ProcessoDTO>();

        for(Processo p: lp){
        ProcessoDTO pd = new ProcessoDTO(p,mc,uc);
        listaProcessoDTO.add(pd);
        }

        return  listaProcessoDTO;
    }

}
