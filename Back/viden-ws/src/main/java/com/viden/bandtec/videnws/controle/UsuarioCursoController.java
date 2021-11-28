package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.arquivos.PilhaObj;
import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import com.viden.bandtec.videnws.repositorio.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios_cursos")
public class UsuarioCursoController {

    @Autowired
    private UsuarioCursoRepository repository;

    @GetMapping("/recent-cursos/{fkUsuario}")
    public ResponseEntity getMyCurso(@PathVariable Integer fkUsuario){
        List<UsuarioCurso> cursos = repository.findAll();
        PilhaObj<UsuarioCurso> meusCursos = new PilhaObj(cursos.size());
        for (UsuarioCurso cursoDaVez : cursos) {
            if(cursoDaVez.getFkUsuario().equals(fkUsuario)){
                meusCursos.push(cursoDaVez);
            }
        }
        List<UsuarioCurso> retorno = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            retorno.add(meusCursos.pop());
            if(meusCursos.isEmpty()){
                break;
            }
        }
        if(retorno.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(retorno);
    }

    @PostMapping("/recent-cursos")
    public ResponseEntity postRecentCurso(@RequestBody UsuarioCurso newCurso){
        if(!repository.existsById(newCurso.getFkCurso())){
            repository.save(newCurso);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/cursos-finalizados/{fkUsuario}")
    public ResponseEntity getCursoFinalizados(@PathVariable Integer fkUsuario){
        List<UsuarioCurso> cursos = repository.findAll();
        PilhaObj<UsuarioCurso> cursosFinalizados = new PilhaObj(cursos.size());
        for (UsuarioCurso cursoDaVez : cursos) {
            if(cursoDaVez.getFkUsuario().equals(fkUsuario)){
                if(cursoDaVez.getFinalizado().equals(1)){
                    cursosFinalizados.push(cursoDaVez);
                }
            }
        }
        List<UsuarioCurso> retorno = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            retorno.add(cursosFinalizados.pop());
            if(cursosFinalizados.isEmpty()){
                break;
            }
        }
        if(retorno.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(retorno);
    }

    @PatchMapping("/cursos-finalizados/{finalizado}/{fkCurso}/{fkUsuario}")
    public ResponseEntity patchCursosFinalizados(@PathVariable Integer finalizado,
                                                 @PathVariable Integer fkCurso,
                                                 @PathVariable Integer fkUsuario){
        if(repository.existsById(fkCurso)){
            repository.atualizarFinalizado(finalizado,fkCurso,fkUsuario);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(404).build();
    }
}
