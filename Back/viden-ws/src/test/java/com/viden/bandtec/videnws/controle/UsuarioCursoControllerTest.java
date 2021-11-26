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
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNomeUsuario("Winicius");

        Usuario usuario2 = new Usuario();
        usuario.setIdUsuario(2);
        usuario.setNomeUsuario("Jorge");

        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setNomeCurso("Java X");

        Curso curso2 = new Curso();
        curso.setIdCurso(2);
        curso.setNomeCurso("PHP 9");

        Curso curso3 = new Curso();
        curso.setIdCurso(3);
        curso.setNomeCurso("Angular 7");

        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setIdUsuarioCurso(1);
        usuarioCurso.setFkUsuario(usuario);
        usuarioCurso.setFkCurso(curso);
        usuarioCurso.setFinalizado(1);

        UsuarioCurso usuarioCurso2 = new UsuarioCurso();
        usuarioCurso.setIdUsuarioCurso(2);
        usuarioCurso.setFkUsuario(usuario);
        usuarioCurso.setFkCurso(curso2);
        usuarioCurso.setFinalizado(0);

        UsuarioCurso usuarioCurso3 = new UsuarioCurso();
        usuarioCurso.setIdUsuarioCurso(3);
        usuarioCurso.setFkUsuario(usuario2);
        usuarioCurso.setFkCurso(curso3);
        usuarioCurso.setFinalizado(1);

        UsuarioCurso usuarioCurso4 = new UsuarioCurso();
        usuarioCurso.setIdUsuarioCurso(4);
        usuarioCurso.setFkUsuario(usuario);
        usuarioCurso.setFkCurso(curso3);
        usuarioCurso.setFinalizado(1);

        List<UsuarioCurso> usuarioCursosMock = List.of(
            usuarioCurso,usuarioCurso2,usuarioCurso3,usuarioCurso4
        );

        when(repository.findAll()).thenReturn(usuarioCursosMock);

        ResponseEntity response = controller.getCursoFinalizados(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}