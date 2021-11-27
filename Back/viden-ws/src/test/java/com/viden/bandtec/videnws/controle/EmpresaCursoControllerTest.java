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
        EmpresaCurso empresaCurso = new EmpresaCurso();
        empresaCurso.setIdEmpresaCurso(1);
        empresaCurso.setFkCurso(1);
        empresaCurso.setFkEmpresa(1);

        EmpresaCurso empresaCurso2 = new EmpresaCurso();
        empresaCurso2.setIdEmpresaCurso(2);
        empresaCurso2.setFkCurso(2);
        empresaCurso2.setFkEmpresa(2);

        EmpresaCurso empresaCurso3 = new EmpresaCurso();
        empresaCurso3.setIdEmpresaCurso(3);
        empresaCurso3.setFkCurso(3);
        empresaCurso3.setFkEmpresa(3);


        List<EmpresaCurso> empresaCursosMock = List.of(
                empresaCurso, empresaCurso2, empresaCurso3
        );

        when(repository.findAll()).thenReturn(empresaCursosMock);

        ResponseEntity response = controller.getEmpresaByCurso(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }
}