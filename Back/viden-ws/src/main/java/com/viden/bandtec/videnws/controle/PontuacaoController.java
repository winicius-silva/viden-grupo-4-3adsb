package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Pontuacao;
import com.viden.bandtec.videnws.repositorio.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pontuacoes")
public class PontuacaoController {

    @Autowired
    private PontuacaoRepository repository;

    @GetMapping
    public ResponseEntity getPontos(){
        List<Pontuacao> pontuacoes = repository.findAll();
        if(pontuacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pontuacoes);
    }

    @PostMapping
    public ResponseEntity postPontos(@RequestBody Pontuacao novosPontos){
        repository.save(novosPontos);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{fkUsuario}")
    public ResponseEntity getPontosPorUsuario(@PathVariable Integer fkUsuario){
        List<Pontuacao> pontuacoes = repository.findAllByFkUsuario(fkUsuario);
        if(pontuacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pontuacoes);
    }

    @GetMapping("/total/{fkUsuario}")
    public ResponseEntity getPontosTotalPorUsuario(@PathVariable Integer fkUsuario){
        Double total = 0.0;
        List<Pontuacao> pontos = repository.findAllByFkUsuario(fkUsuario);
        for (Pontuacao ponto : pontos) {
            total += ponto.getPontos();
        }
       Pontuacao novaPontuacao = new Pontuacao();
       novaPontuacao.setPontos(total);
       return ResponseEntity.status(200).body(novaPontuacao);
    }
}
