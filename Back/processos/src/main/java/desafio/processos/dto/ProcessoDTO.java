package desafio.processos.dto;

import desafio.processos.controller.MunicipioController;
import desafio.processos.controller.UfController;
import desafio.processos.entity.Processo;
import desafio.processos.service.ProcessoService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProcessoDTO {

    private Long id;

    private String npu;

    private LocalDate dataCadatro;

    private LocalDate dataVisualizacao;

    private MunicipioDTO municipio;

    private  UfDTO uf;

    public ProcessoDTO(String npu, LocalDate dataCadatro, LocalDate dataVisualizacao, Long municipio, Long uf) {
        UfController ufController = new UfController();
        MunicipioController municipioController = new MunicipioController();

        this.npu = npu;
        this.dataCadatro = dataCadatro;
        this.dataVisualizacao = dataVisualizacao;
        this.municipio = municipioController.consultarMunicipioPorID(municipio).getBody();
        this.uf = ufController.consultarUfPorId(uf).getBody();
    }

    public ProcessoDTO(Long id,String npu, LocalDate dataCadatro, LocalDate dataVisualizacao, Long municipio, Long uf) {
        UfController ufController = new UfController();
        MunicipioController municipioController = new MunicipioController();

        this.id=id;
        this.npu = npu;
        this.dataCadatro = dataCadatro;
        this.dataVisualizacao = dataVisualizacao;
        this.municipio = municipioController.consultarMunicipioPorID(municipio).getBody();
        this.uf = ufController.consultarUfPorId(uf).getBody();
    }
    public Processo transformarDTOemPRocesso(ProcessoService processoService){

                Processo processo = new Processo();

                processo.setNpu(this.npu);
                processo.setDataVisualizacao(this.dataVisualizacao);
                processo.setDataCadastro(this.dataCadatro);
                processo.setUf(this.uf.getId());
                processo.setMunicipio(this.municipio.getId());

                processo = processoService.create(processo);

                return processo;
            };

    public ProcessoDTO transformarPRocessoEmDTIO(Processo p){

        ProcessoDTO processoDTO = new ProcessoDTO();
        UfController ufController = new UfController();
        MunicipioController municipioController = new MunicipioController();


        this.setId(p.getId());
        this.setNpu(p.getNpu());
        this.setUf(ufController.consultarUfPorId(p.getUf()).getBody());
        this.setMunicipio(municipioController.consultarMunicipioPorID(p.getMunicipio()).getBody());


        return processoDTO;
    };
}
