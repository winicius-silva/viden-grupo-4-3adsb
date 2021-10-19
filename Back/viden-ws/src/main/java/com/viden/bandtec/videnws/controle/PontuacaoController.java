package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Pontuacao;
import com.viden.bandtec.videnws.repositorio.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{fk_usuario}")
    public ResponseEntity getPontosPorUsuario(@PathVariable Integer fk_usuario){
        List<Pontuacao> pontuacoes = repository.findAllByFkusuario(fk_usuario);
        if(pontuacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pontuacoes);
    }

    @GetMapping("/total/{fk_usuario}")
    public ResponseEntity getPontosTotalPorUsuario(@PathVariable Integer fk_usuario){
        Double total = 0.0;
        List<Pontuacao> pontos = repository.findAllByFkusuario(fk_usuario);
        for (Pontuacao ponto : pontos) {
            total += ponto.getPontos();
        }
       Pontuacao novaPontuacao = new Pontuacao();
       novaPontuacao.setId_pontos_usuario(0);
       novaPontuacao.setData(null);
       novaPontuacao.setPontos(total);
       novaPontuacao.setFk_usuario(fk_usuario);
       novaPontuacao.setFk_curso(null);
       return ResponseEntity.status(200).body(novaPontuacao);
    }
}
