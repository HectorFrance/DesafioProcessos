package desafio.processos.controller;

import desafio.processos.dto.UfSimpDTO;
import desafio.processos.dto.ufDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/uf")
public class UfController {

    String urlIbgeUf= "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

    @GetMapping("/uf")
    public ResponseEntity<List<ufDTO>> consultarUff() {
        RestTemplate restTemplate = new RestTemplate();
        return ResponseEntity.ok().body(restTemplate.exchange(
                urlIbgeUf,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ufDTO>>() {
                }
        ).getBody());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ufDTO> consultarUff(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlIbgeUf+"/"+id.toString();
        return ResponseEntity.ok().body(restTemplate.getForEntity(url, ufDTO.class)
        ).getBody();

    }

    @GetMapping()
    public ResponseEntity<List<UfSimpDTO>>consultarUf() {
        RestTemplate restTemplate = new RestTemplate();
        List<UfSimpDTO> listaUfSimp = new ArrayList<>();
        List<ufDTO> listaUf = restTemplate.exchange(
                urlIbgeUf+"?orderBy=nome",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ufDTO>>() {
                }
        ).getBody();

        listaUf.forEach(uf ->listaUfSimp.add(new UfSimpDTO(uf.getId(),uf.getSigla(),uf.getNome())));

        return ResponseEntity.ok().body(listaUfSimp);
    }
}
