package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.dominio.Empresa;
import com.viden.bandtec.videnws.dominio.EmpresaCurso;
import com.viden.bandtec.videnws.repositorio.EmpresaCursoRepository;
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
class EmpresaCursoControllerTest {

    @Autowired
    EmpresaCursoController controller;

    @MockBean
    EmpresaCursoRepository repository;

    @Test
    void getCursosLigadosEmpresas(){
        Empresa empresa = new Empresa(1, "Viden");
        Empresa empresa2 = new Empresa(2, "SPTech");


        Curso curso = new Curso(1, "Java X");
        Curso curso2 = new Curso(2, "PHP 9");
        Curso curso3 = new Curso(3, "Angular 7");


        List<EmpresaCurso> empresaCursosMock = List.of(
                new EmpresaCurso(1, empresa, curso, LocalDate.now()),
                new EmpresaCurso(2, empresa, curso2, LocalDate.now()),
                new EmpresaCurso(3, empresa, curso3, LocalDate.now()),
                new EmpresaCurso(4, empresa2, curso, LocalDate.now())
        );

        when(repository.findAll()).thenReturn(empresaCursosMock);

        ResponseEntity response = controller.getEmpresaByCurso(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}