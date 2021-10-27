package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.repositorio.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios_cursos")
public class UsuarioCursoController {

    @Autowired
    private UsuarioCursoRepository repository;
}
