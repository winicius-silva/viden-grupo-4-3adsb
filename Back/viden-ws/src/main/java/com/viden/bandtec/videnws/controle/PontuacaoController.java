package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Pontuacao;
import com.viden.bandtec.videnws.repositorio.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pontuacoes")
public class PontuacaoController {

    @Autowired
    private PontuacaoRepository repository;

    @GetMapping
    public List<Pontuacao> getPontos(){
        return repository.findAll();
    }

    @PostMapping
    public String postPontos(@RequestBody Pontuacao novosPontos){
        repository.save(novosPontos);
        return "Pontos adicionados ao usuario: "+ novosPontos.getFk_usuario();
    }

    @GetMapping("/{fk_usuario}")
    public List<Pontuacao> getPontosPorUsuario(@PathVariable Integer fk_usuario){
        return repository.findAllByFkusuario(fk_usuario);
    }

    @GetMapping("/total/{fk_usuario}")
    public Pontuacao getPontosTotalPorUsuario(@PathVariable Integer fk_usuario){
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
       return novaPontuacao;
    }
}
