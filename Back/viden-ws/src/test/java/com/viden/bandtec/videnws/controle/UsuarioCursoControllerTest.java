package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.dominio.Usuario;
import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import com.viden.bandtec.videnws.repositorio.UsuarioCursoRepository;
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
class UsuarioCursoControllerTest {

    @Autowired
    UsuarioCursoController controller;

    @MockBean
    UsuarioCursoRepository repository;

    @Test
    void getCursoFinalizados(){
        Usuario usuario = new Usuario(1, "Winicius");
        Usuario usuario2 = new Usuario(2, "Jorge");
        Curso curso = new Curso(1, "Java X");
        Curso curso2 = new Curso(2, "PHP 9");
        Curso curso3 = new Curso(3, "Angular 7");

        List<UsuarioCurso> usuarioCursosMock = List.of(
            new UsuarioCurso(1, usuario,curso, 1,LocalDate.now(), 100.0),
            new UsuarioCurso(2, usuario,curso2, 0,LocalDate.now(), 80.0),
            new UsuarioCurso(3, usuario2,curso3, 1,LocalDate.now(), 15.5),
            new UsuarioCurso(4, usuario,curso3, 1,LocalDate.now(), 100.5)
        );

        when(repository.findAll()).thenReturn(usuarioCursosMock);

        ResponseEntity response = controller.getCursoFinalizados(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}