package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.arquivos.PilhaObj;
import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import com.viden.bandtec.videnws.repositorio.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios_cursos")
public class UsuarioCursoController {

    @Autowired
    private UsuarioCursoRepository repository;

    @GetMapping("/recent-cursos/{FkUsuario}/{date}")
    private ResponseEntity getRecentCurso(@PathVariable Integer FkUsuario, @PathVariable LocalDate date){
        List<UsuarioCurso> cursosRecentes = repository.findByFkUsuarioAndDateGreaterThan(FkUsuario, date);
        PilhaObj pilhaCurso = new PilhaObj(cursosRecentes.size());
        for (UsuarioCurso cursoRecente : cursosRecentes) {
            pilhaCurso.push(cursoRecente);
        }
        if(pilhaCurso.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(pilhaCurso);
        }
    }
}
