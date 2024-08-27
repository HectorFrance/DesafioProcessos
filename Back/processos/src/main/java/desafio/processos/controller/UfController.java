package desafio.processos.controller;

import desafio.processos.dto.UfDTO;
import desafio.processos.exception.UfNotFounException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/uf")
public class UfController {

    String urlIbgeUf= "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

    @GetMapping("/uf")
    public ResponseEntity<List<UfDTO>> consultarUff() {
        RestTemplate restTemplate = new RestTemplate();
        return ResponseEntity.ok().body(restTemplate.exchange(
                urlIbgeUf+"?orderBy=id",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UfDTO>>() {
                }
        ).getBody());

    }

    @GetMapping("/{id}")
    public ResponseEntity<UfDTO> consultarUfPorId(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlIbgeUf+"/"+id.toString();
        UfDTO uf =null;
        try {
            uf=restTemplate.getForEntity(url, UfDTO.class).getBody();
        }catch (RestClientException e){
            throw new UfNotFounException(e.getMessage(),id.toString());
        }
        return ResponseEntity.ok().body(uf);

    }

    @GetMapping()
    public ResponseEntity<List<UfDTO>>listarTodosUf() {
        RestTemplate restTemplate = new RestTemplate();
        List<UfDTO> listaUf = restTemplate.exchange(
                urlIbgeUf+"?orderBy=nome",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UfDTO>>() {
                }
        ).getBody();

        return ResponseEntity.ok().body(listaUf);
    }

}
