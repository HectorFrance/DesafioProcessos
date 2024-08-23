package desafio.processos.controller;

import desafio.processos.dto.MunicipioDTO;
import desafio.processos.dto.ufDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("municipio")
public class MunicipioController {

    String buscarPorMunicipio(Long id) {
        return "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + id + "/municipios";
    }

    String urlIbgeMunicipio = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";


    @GetMapping("/{id}")
    public ResponseEntity<MunicipioDTO> consultarMunicipio(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(id);
        String url = urlIbgeMunicipio + "/" + id.toString();
        System.out.println("URL COM : " + url);
        System.out.println(ResponseEntity.ok().body(restTemplate.getForEntity(url, Object.class)
        ).getBody());
        return ResponseEntity.ok().body(restTemplate.getForEntity(url, MunicipioDTO.class)
        ).getBody();

    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ufDTO> consultarMunicipio(@PathVariable String nome) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(nome);
        String url = urlIbgeMunicipio + "/" + nome;
        System.out.println("URL COM : " + url);
        return ResponseEntity.ok().body(restTemplate.getForEntity(url, ufDTO.class)
        ).getBody();

    }
}