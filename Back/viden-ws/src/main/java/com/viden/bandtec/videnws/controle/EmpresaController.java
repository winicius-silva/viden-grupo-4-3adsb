package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Empresa;
import com.viden.bandtec.videnws.dominio.Usuario;
import com.viden.bandtec.videnws.repositorio.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public ResponseEntity getEmpresas(){
        List<Empresa> empresas = repository.findAll();
        if (empresas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(empresas);
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity getEmpresaById(@PathVariable Integer idEmpresa){
        return ResponseEntity.of(repository.findById(idEmpresa));
    }

}
