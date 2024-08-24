package desafio.processos.exception;

import lombok.Getter;

@Getter
public class MunicipioNotFounException extends RuntimeException {

    private String municipio;


    public MunicipioNotFounException(String message, String municipio)
    {
        super(message);
        this.municipio=municipio;

    }
}
