package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.arquivos.PilhaObj;
import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import com.viden.bandtec.videnws.repositorio.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios_cursos")
public class UsuarioCursoController {

    @Autowired
    private UsuarioCursoRepository repository;

    @GetMapping("/recent-cursos/{fkUsuario}")
    private ResponseEntity getRecentCurso(@PathVariable Integer fkUsuario){
        List<UsuarioCurso> cursos = repository.findAll();
        PilhaObj<UsuarioCurso> myCursos = new PilhaObj(cursos.size());
        for (UsuarioCurso cursoDaVez : cursos) {
            if(cursoDaVez.getFkUsuario().getIdUsuario().equals(fkUsuario)){
                if(cursoDaVez.getDate() >= 20210101){
                    myCursos.push(cursoDaVez);
                }
            }
        }
        if(myCursos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(myCursos);
    }

    @GetMapping("my-cursos/{fkUsuario}")
    private ResponseEntity getMyCurso(@PathVariable Integer fkUsuario){
        List<UsuarioCurso> cursos = repository.findAll();
        PilhaObj<UsuarioCurso> myCursos = new PilhaObj(cursos.size());
        for (UsuarioCurso cursoDaVez : cursos) {
            if(cursoDaVez.getFkUsuario().getIdUsuario().equals(fkUsuario)){
                myCursos.push(cursoDaVez);
            }
        }
        if(myCursos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(myCursos);
    }

    @GetMapping("cursos-finalizados/{fkUsuario}")
    private ResponseEntity getCursoFinalizados(@PathVariable Integer fkUsuario){
        List<UsuarioCurso> cursos = repository.findAll();
        PilhaObj<UsuarioCurso> cursosFinalizados = new PilhaObj(cursos.size());
        for (UsuarioCurso cursoDaVez : cursos) {
            if(cursoDaVez.getFkUsuario().getIdUsuario().equals(fkUsuario)){
                if(cursoDaVez.getFinalizado().equals(1)){
                    cursosFinalizados.push(cursoDaVez);
                }
            }
        }
        if(cursosFinalizados.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(cursosFinalizados);
    }
}
