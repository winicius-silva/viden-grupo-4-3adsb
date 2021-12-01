package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Empresa;
import com.viden.bandtec.videnws.repositorio.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
class EmpresaControllerTest {

    @Autowired
    EmpresaController controller;

    @MockBean
    EmpresaRepository repository;

    @Test
    void getOneEmpresa(){
        Empresa empresa = new Empresa(1, "Valemobi", "1111231231", "Rua teste",
                "valemobi@valemobi.com.br", "Teste123", "1 ano", 5000.0);

        when(repository.findById(empresa.getIdEmpresa())).thenReturn(Optional.of(empresa));

        ResponseEntity response = controller.getEmpresaById(1);

        assertEquals(200, response.getStatusCodeValue());

        assertTrue(response.hasBody());
    }

}