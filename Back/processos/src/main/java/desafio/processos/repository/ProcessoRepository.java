package desafio.processos.repository;

import desafio.processos.entity.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo,Long> {

    
}
