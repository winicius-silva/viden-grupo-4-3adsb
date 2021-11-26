package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.arquivos.FilaObj;
import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.repositorio.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public ResponseEntity getCurso(){
        if(repository.count() == 0){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(repository.findAll());
        }
    }

    @GetMapping("/filter/{categoria}")
    public ResponseEntity getCursoCategoria(@PathVariable String categoria){
        List<Curso> cursos = repository.findByCategoria(categoria);
        if(cursos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(cursos);
        }
    }

    @GetMapping("/search/{nomeCurso}")
    public ResponseEntity getCursosSearch(@PathVariable String nomeCurso){
        List<Curso> cursos = repository.findAll();
        FilaObj<Curso> filaCurso = new FilaObj<>(cursos.size());
        for (Curso cursoDaVez : cursos) {
            if(cursoDaVez.getNomeCurso().equals(nomeCurso)){
                filaCurso.insert(cursoDaVez);
            }
        }
        List<Curso> retorno = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            retorno.add(filaCurso.poll());
            if (filaCurso.isEmpty()) {
                break;
            }
        }
        if(retorno.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(retorno);
        }
    }

    @GetMapping("/sub-categoria/{subCategoria}")
    public ResponseEntity getCursoSubCategoria(@PathVariable String subCategoria){
        List<Curso> cursos = repository.findBySubCategoria(subCategoria);
        if(cursos.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(cursos);
        }
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity getOneCurso(@PathVariable Integer idCurso){
        return ResponseEntity.of(repository.findById(idCurso));
    }

}
