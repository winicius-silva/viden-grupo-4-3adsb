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
        Curso curso = new Curso();
        curso.setIdCurso(1);
        curso.setNomeCurso("Java X");

        Curso curso2 = new Curso();
        curso.setIdCurso(2);
        curso.setNomeCurso("PHP 9");

        Curso curso3 = new Curso();
        curso.setIdCurso(3);
        curso.setNomeCurso("Angular 7");

        Empresa empresa = new Empresa(1, "Viden", "85506733000155",
                "Rua Teste 123", "viden@viden.com.br", "Viden123",
                "2021/01/01 a 2022/01/01", 5000.0);

        Empresa empresa2 = new Empresa(2, "Bandtec", "85506733000155",
                "Rua Teste 123", "bandtec@bandtec.com.br", "Bandtec123",
                "2021/01/01 a 2022/01/01", 5500.0);

        EmpresaCurso empresaCurso = new EmpresaCurso();
        empresaCurso.setIdEmpresaCurso(1);
        empresaCurso.setFkCurso(curso);
        empresaCurso.setFkEmpresa(empresa);

        EmpresaCurso empresaCurso2 = new EmpresaCurso();
        empresaCurso.setIdEmpresaCurso(2);
        empresaCurso.setFkCurso(curso2);
        empresaCurso.setFkEmpresa(empresa);

        EmpresaCurso empresaCurso3 = new EmpresaCurso();
        empresaCurso.setIdEmpresaCurso(3);
        empresaCurso.setFkCurso(curso3);
        empresaCurso.setFkEmpresa(empresa);


        List<EmpresaCurso> empresaCursosMock = List.of(
                empresaCurso, empresaCurso2, empresaCurso3
        );

        when(repository.findAll()).thenReturn(empresaCursosMock);

        ResponseEntity response = controller.getEmpresaByCurso(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}