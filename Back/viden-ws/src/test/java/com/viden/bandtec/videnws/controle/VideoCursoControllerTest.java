package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.dominio.VideoCurso;
import com.viden.bandtec.videnws.repositorio.VideoCursoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
class VideoCursoControllerTest {

    @Autowired
    VideoCursoController controller;

    @MockBean
    VideoCursoRepository repository;

    @Test
    void getVideoByCurso(){
        Curso curso = new Curso(1, "Java X");

        List<VideoCurso> videoCursosMock = List.of(
                new VideoCurso(1, curso,
                    "https://www.youtube.com/watch?v=dM7x1PNZDo0", "teste"),
                new VideoCurso(2, curso,
                        "https://www.youtube.com/watch?v=7CjBOajCSD4", "teste"),
                new VideoCurso(3, curso,
                        "https://www.youtube.com/watch?v=wXmPralkTqQ", "teste")
        );

        when(repository.findAll()).thenReturn(videoCursosMock);

        ResponseEntity response = controller.getVideoByCurso(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }

}