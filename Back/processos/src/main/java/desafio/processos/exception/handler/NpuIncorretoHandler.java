package desafio.processos.exception.handler;

import desafio.processos.exception.NpuIncorretoExcepiotn;
import desafio.processos.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NpuIncorretoHandler {

    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @ExceptionHandler(NpuIncorretoExcepiotn.class)
    public ErrorDTO handler(NpuIncorretoExcepiotn ex){
        return new ErrorDTO(
                "Error: "+ ex.getMessage(),
                ex.getLacamento()
        );
    }
}
