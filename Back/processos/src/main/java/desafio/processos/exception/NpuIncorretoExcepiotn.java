package desafio.processos.exception;

import lombok.Getter;

@Getter
public class NpuIncorretoExcepiotn extends RuntimeException{

    private String lacamento;

    public NpuIncorretoExcepiotn(String message,String lacamento){
        super(message);
        this.lacamento=lacamento;
    }


}
