package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import com.viden.bandtec.videnws.repositorio.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/usuarios_cursos")
public class UsuarioCursoController {

    @Autowired
    private UsuarioCursoRepository repository;

    @GetMapping("/recent-cursos/{idUsuario}/{date}")
    private ResponseEntity getRecentCurso(@PathVariable Integer idUsuario, @PathVariable LocalDate date){
        List<UsuarioCurso> usuarioCursos = repository.findByIdUsuarioAndDateGreaterThan(idUsuario, date);
        if(usuarioCursos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(usuarioCursos);
        }
    }
}
