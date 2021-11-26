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
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNomeUsuario("Winicius");

        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setNomeCurso("Java X");

        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setId_pontos_usuario(1);
        pontuacao.setFkusuario(usuario);
        pontuacao.setPontos(4.5);
        pontuacao.setFkcurso(curso);

        ResponseEntity response = controller.postPontos(pontuacao);

        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    void getPontosPorUsuario(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNomeUsuario("Winicius");

        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setNomeCurso("Java X");

        Curso curso2 = new Curso();
        curso.setIdCurso(2);
        curso.setNomeCurso("PHP 9");

        Curso curso3 = new Curso();
        curso.setIdCurso(3);
        curso.setNomeCurso("Angular 7");

        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setId_pontos_usuario(1);
        pontuacao.setFkusuario(usuario);
        pontuacao.setPontos(4.5);
        pontuacao.setFkcurso(curso);

        Pontuacao pontuacao2 = new Pontuacao();
        pontuacao.setId_pontos_usuario(2);
        pontuacao.setFkusuario(usuario);
        pontuacao.setPontos(3.0);
        pontuacao.setFkcurso(curso2);

        Pontuacao pontuacao3 = new Pontuacao();
        pontuacao.setId_pontos_usuario(3);
        pontuacao.setFkusuario(usuario);
        pontuacao.setPontos(2.5);
        pontuacao.setFkcurso(curso3);

        List<Pontuacao> pontuacaoMock = List.of(
                pontuacao,pontuacao2,pontuacao3
        );

        when(repository.findAll()).thenReturn(pontuacaoMock);

        ResponseEntity response = controller.getPontosPorUsuario(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}