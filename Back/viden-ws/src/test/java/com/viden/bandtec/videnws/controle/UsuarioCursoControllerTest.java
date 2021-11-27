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
        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setIdUsuarioCurso(1);
        usuarioCurso.setFkUsuario(1);
        usuarioCurso.setFkCurso(1);
        usuarioCurso.setFinalizado(1);

        UsuarioCurso usuarioCurso2 = new UsuarioCurso();
        usuarioCurso2.setIdUsuarioCurso(2);
        usuarioCurso2.setFkUsuario(1);
        usuarioCurso2.setFkCurso(2);
        usuarioCurso2.setFinalizado(0);

        UsuarioCurso usuarioCurso3 = new UsuarioCurso();
        usuarioCurso3.setIdUsuarioCurso(3);
        usuarioCurso3.setFkUsuario(2);
        usuarioCurso3.setFkCurso(3);
        usuarioCurso3.setFinalizado(1);

        UsuarioCurso usuarioCurso4 = new UsuarioCurso();
        usuarioCurso4.setIdUsuarioCurso(4);
        usuarioCurso4.setFkUsuario(1);
        usuarioCurso4.setFkCurso(3);
        usuarioCurso4.setFinalizado(1);

        List<UsuarioCurso> usuarioCursosMock = List.of(
            usuarioCurso,usuarioCurso2,usuarioCurso3,usuarioCurso4
        );

        when(repository.findAll()).thenReturn(usuarioCursosMock);

        ResponseEntity response = controller.getCursoFinalizados(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}