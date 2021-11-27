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
        VideoCurso videoCurso = new VideoCurso();
        videoCurso.setIdVideoCurso(1);
        videoCurso.setIdCurso(1);
        videoCurso.setLink("https://www.youtube.com/watch?v=dM7x1PNZDo0");

        VideoCurso videoCurso2 = new VideoCurso();
        videoCurso2.setIdVideoCurso(2);
        videoCurso2.setIdCurso(1);
        videoCurso2.setLink("https://www.youtube.com/watch?v=7CjBOajCSD4");

        VideoCurso videoCurso3 = new VideoCurso();
        videoCurso3.setIdVideoCurso(3);
        videoCurso3.setIdCurso(1);
        videoCurso3.setLink("https://www.youtube.com/watch?v=wXmPralkTqQ");

        List<VideoCurso> videoCursosMock = List.of(
                videoCurso,videoCurso2,videoCurso3
        );

        when(repository.findAll()).thenReturn(videoCursosMock);

        ResponseEntity response = controller.getVideoByCurso(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }

}