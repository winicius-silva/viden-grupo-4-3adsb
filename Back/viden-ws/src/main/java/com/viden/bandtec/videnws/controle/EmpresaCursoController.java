package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.repositorio.EmpresaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas_cursos")
public class EmpresaCursoController {

    @Autowired
    private EmpresaCursoRepository repository;
}
