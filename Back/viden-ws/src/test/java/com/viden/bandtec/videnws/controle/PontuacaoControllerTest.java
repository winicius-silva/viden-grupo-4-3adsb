package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.dominio.Pontuacao;
import com.viden.bandtec.videnws.dominio.Usuario;
import com.viden.bandtec.videnws.repositorio.PontuacaoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class PontuacaoControllerTest {

    @Autowired
    PontuacaoController controller;

    @MockBean
    PontuacaoRepository repository;

    @Test
    void postPontos(){
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setIdPontosUsuario(1);
        pontuacao.setFkUsuario(1);
        pontuacao.setPontos(4.5);
        pontuacao.setFkCurso(1);

        ResponseEntity response = controller.postPontos(pontuacao);

        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    void getPontosPorUsuario(){
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setIdPontosUsuario(1);
        pontuacao.setFkUsuario(1);
        pontuacao.setPontos(4.5);
        pontuacao.setFkCurso(1);

        Pontuacao pontuacao2 = new Pontuacao();
        pontuacao2.setIdPontosUsuario(2);
        pontuacao2.setFkUsuario(1);
        pontuacao2.setPontos(3.0);
        pontuacao2.setFkCurso(2);

        Pontuacao pontuacao3 = new Pontuacao();
        pontuacao3.setIdPontosUsuario(3);
        pontuacao3.setFkUsuario(1);
        pontuacao3.setPontos(2.5);
        pontuacao3.setFkCurso(3);

        List<Pontuacao> pontuacaoMock = List.of(
                pontuacao,pontuacao2,pontuacao3
        );

        when(repository.findAll()).thenReturn(pontuacaoMock);

        ResponseEntity response = controller.getPontosPorUsuario(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}