package desafio.processos.service;

import desafio.processos.entity.Processo;
import desafio.processos.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository repository;

    public Processo create(Processo obj){
        return repository.save(obj);
    }

    public void deleteByid(Long id){
        repository.deleteById(id);
    }


    public Processo getById(Long id){
        Optional<Processo> obj = repository.findById(id);
        return obj.get();
    }

    public List<Processo> getAll(){
        return repository.findAll();
    }

    public Processo update(Processo obj){
        Optional<Processo> updatedObj = repository.findById(obj.getId());
        updateProcesso(updatedObj, obj);
        return repository.save(updatedObj.get());
    }

    private void updateProcesso(Optional<Processo> updatedObj, Processo obj) {

        updatedObj.get().setUf(obj.getUf());
        updatedObj.get().setNpu(obj.getNpu());
        updatedObj.get().setMunicipio(obj.getMunicipio());
        updatedObj.get().setDataCadatro(obj.getDataCadatro());
        updatedObj.get().setDataVisualizacao(obj.getDataVisualizacao());
    }
}
