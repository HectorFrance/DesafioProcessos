package desafio.processos.controller;

import desafio.processos.dto.ProcessoDTO;
import desafio.processos.entity.Processo;
import desafio.processos.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService service;

    @Autowired
    private  MunicipioController municipioController;

    @Autowired
    private  UfController ufController;

    @GetMapping
    public ResponseEntity<List<ProcessoDTO>> getAll() {
        ProcessoDTO processoDTO=new ProcessoDTO();
        List<ProcessoDTO> lista= processoDTO.transformarLista(service.getAll(),municipioController,ufController);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProcessoDTO> getById(@PathVariable Long id) {
        ProcessoDTO processoDTO=new ProcessoDTO(service.getById(id), municipioController,ufController);
        return ResponseEntity.ok().body(processoDTO);
    }

    @PostMapping
    public ResponseEntity<Processo> create(@RequestBody Processo obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteByid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Processo> update(@PathVariable Long id, @RequestBody Processo obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }


}
