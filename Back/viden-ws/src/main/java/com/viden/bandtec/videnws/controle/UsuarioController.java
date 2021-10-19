package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Usuario;
import com.viden.bandtec.videnws.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity getUsuario(){
        List<Usuario> usuarios = repository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity getUsuario(@PathVariable Integer id_usuario){
        return ResponseEntity.of(repository.findById(id_usuario));
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody Usuario novoUsuario){
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity login(@PathVariable String email,@PathVariable String senha){
        Usuario usuarios = repository.findByEmailAndSenha(email,senha);
        if(usuarios == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).build();
    }

}
