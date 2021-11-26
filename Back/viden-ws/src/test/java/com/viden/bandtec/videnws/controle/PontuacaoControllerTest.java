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
        Usuario usuario = new Usuario(1, "Winicius");
        Curso curso = new Curso(1, "Java X");

        ResponseEntity response = controller.postPontos(
                new Pontuacao(1, LocalDate.now(),4.5, usuario,curso));

        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    void getPontosPorUsuario(){
        Usuario usuario = new Usuario(1, "Winicius");
        Curso curso = new Curso(1, "Java X");
        Curso curso2 = new Curso(2, "PHP 9");
        Curso curso3 = new Curso(3, "Angular 7");

        List<Pontuacao> pontuacaoMock = List.of(
                new Pontuacao(1, LocalDate.now(),4.5, usuario,curso),
                new Pontuacao(2, LocalDate.now(),3.0, usuario,curso2),
                new Pontuacao(3, LocalDate.now(),2.5, usuario,curso3)
        );

        when(repository.findAll()).thenReturn(pontuacaoMock);

        ResponseEntity response = controller.getPontosPorUsuario(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}