package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.repositorio.CursoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CursoControllerTest {

   @Autowired
   CursoController controller;

   @MockBean
   CursoRepository repository;

   @Test
   void getCursosPesquisados(){
       Curso curso = new Curso();
       curso.setIdCurso(1);
       curso.setNomeCurso("Java X");

       Curso curso2 = new Curso();
       curso.setIdCurso(2);
       curso.setNomeCurso("PHP 9");

       Curso curso3 = new Curso();
       curso.setIdCurso(3);
       curso.setNomeCurso("Angular 7");


           List<Curso> cursosMock = List.of(curso,curso2,curso3);
           when(repository.findAll()).thenReturn(cursosMock);

           ResponseEntity response = controller.getCursosSearch("Java");

           assertEquals(200, response.getStatusCodeValue());

           assertTrue(response.hasBody());
   }
}