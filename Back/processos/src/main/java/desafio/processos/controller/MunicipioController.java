package desafio.processos.controller;

import desafio.processos.dto.MunicipioDTO;
import desafio.processos.exception.MunicipioNotFounException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("municipio")
@CrossOrigin(origins = "*")
public class MunicipioController {


    String buscarPorUF= "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";
    String urlIbgeMunicipio = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";


    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> consultarMunicipioPorID(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlIbgeMunicipio + "/" + id.toString();
        MunicipioDTO municipio= null;
        try {
            municipio = restTemplate.getForEntity(url, MunicipioDTO.class).getBody();
        } catch (RestClientException e) {
            throw new MunicipioNotFounException(e.getMessage(),id.toString());
        }
        return ResponseEntity.ok().body(municipio);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<MunicipioDTO> consultarMunicipioPorNome(@PathVariable String nome) {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlIbgeMunicipio + "/" + nome;
        MunicipioDTO municipio= null;
        try {
            municipio = restTemplate.getForEntity(url, MunicipioDTO.class).getBody();
        } catch (RestClientException e) {
            throw new MunicipioNotFounException(e.getMessage(),nome);
        }
        return ResponseEntity.ok().body(municipio);
    }

    @GetMapping("/uf/{idUF}")
    public ResponseEntity<List<MunicipioDTO>> consultarMunicipioPorUf(@PathVariable Long idUF) {
        RestTemplate restTemplate = new RestTemplate();
        String url = buscarPorUF+ idUF + "/municipios";

        return ResponseEntity.ok().body(restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MunicipioDTO>>() {
                }
        ).getBody());
    }
}