package desafio.processos.exception.handler;

import desafio.processos.dto.ErrorDTO;
import desafio.processos.exception.MunicipioNotFounException;
import desafio.processos.exception.UfNotFounException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(MunicipioNotFounException.class)
    public ErrorDTO MunicipioNotFound(MunicipioNotFounException ex){
        String municipío="Não Foi Possível Localizar o Municipio: "+ ex.getMunicipio();
        String message = ex.getMessage();
        return  new ErrorDTO(message, municipío);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(UfNotFounException.class)
    public ErrorDTO ufNotFound(UfNotFounException ex){
        String uf="Não Foi Possível Localizar o Estado: "+ ex.getUf();
        String message = ex.getMessage();
        return  new ErrorDTO(message, uf);
    }

}
