package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.VideoCurso;
import com.viden.bandtec.videnws.repositorio.VideoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/video-curso")
public class VideoCursoController {

    @Autowired
    private VideoCursoRepository repository;

    @GetMapping("/fkCurso}")
    public ResponseEntity getVideoByCurso(@PathVariable Integer fkCurso){
        List<VideoCurso> videos = repository.findAll();
        List<VideoCurso> retorno = new ArrayList<>();
        for (VideoCurso video : videos) {
            if(video.getFkCurso().equals(fkCurso)){
                retorno.add(video);
            }
        }
        if(retorno.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(retorno);
        }
    }

    @PostMapping
    public ResponseEntity postVideoByCurso(@RequestBody VideoCurso videoNovo){
        repository.save(videoNovo);
        return ResponseEntity.status(201).build();
    }


}
