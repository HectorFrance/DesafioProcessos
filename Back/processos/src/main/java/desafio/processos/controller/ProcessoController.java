package desafio.processos.controller;

import desafio.processos.entity.Processo;
import desafio.processos.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/processos")
@CrossOrigin(origins = "*")
public class ProcessoController {

    @Autowired
    private ProcessoService service;

    @GetMapping
    public ResponseEntity<List<Processo>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Processo> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
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
