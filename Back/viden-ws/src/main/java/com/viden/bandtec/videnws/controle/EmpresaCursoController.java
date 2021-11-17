package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.EmpresaCurso;
import com.viden.bandtec.videnws.repositorio.EmpresaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/empresas_cursos")
public class EmpresaCursoController {

    @Autowired
    private EmpresaCursoRepository repository;

    @PostMapping
    private ResponseEntity postEmpresaByCurso(@RequestBody EmpresaCurso empresaCurso){
        repository.save(empresaCurso);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{FkEmpresa}")
    private ResponseEntity getEmpresaByCurso(@PathVariable Integer FkEmpresa){
        List<EmpresaCurso> cursosEmpresas = repository.findByFkEmpresa(FkEmpresa);
        if(cursosEmpresas.isEmpty()){
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(cursosEmpresas);
        }
    }
}
