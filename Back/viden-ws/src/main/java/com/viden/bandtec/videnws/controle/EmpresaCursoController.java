package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.EmpresaCurso;
import com.viden.bandtec.videnws.repositorio.EmpresaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/empresas_cursos")
public class EmpresaCursoController {

    @Autowired
    private EmpresaCursoRepository repository;

    @PostMapping
    public ResponseEntity postEmpresaByCurso(@RequestBody EmpresaCurso empresaCurso){
        repository.save(empresaCurso);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{fkEmpresa}")
    public ResponseEntity getEmpresaByCurso(@PathVariable Integer fkEmpresa){
        List<EmpresaCurso> cursosEmpresas = repository.findAll();
        List<EmpresaCurso> retorno = new ArrayList<>();
        for (int i = 0; i < cursosEmpresas.size(); i++) {
            if(cursosEmpresas.get(i).getFkEmpresa().getIdEmpresa().equals(fkEmpresa)){
               retorno.add(cursosEmpresas.get(i));
            }
        }
        if(retorno.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(retorno);
        }
    }
}
