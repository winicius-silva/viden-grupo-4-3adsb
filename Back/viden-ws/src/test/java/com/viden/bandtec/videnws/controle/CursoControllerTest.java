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
           List<Curso> cursosMock = List.of(
                   new Curso(1, "Java"),
                   new Curso(2, "PHP"));
           when(repository.findAll()).thenReturn(cursosMock);

           ResponseEntity response = controller.getCursosSearch("Java");

           assertEquals(200, response.getStatusCodeValue());

           assertTrue(response.hasBody());
   }
}