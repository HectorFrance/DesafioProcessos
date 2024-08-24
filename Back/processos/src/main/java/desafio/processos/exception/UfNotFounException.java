package desafio.processos.exception;

import lombok.Getter;

@Getter
public class UfNotFounException extends RuntimeException {
  private String uf;


  public UfNotFounException(String message, String uf)
  {
    super(message);
    this.uf=uf;

  }
}
