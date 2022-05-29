package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Usuario;
import com.viden.bandtec.videnws.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
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
        if(repository.existsByEmail(novoUsuario.getEmail()) || repository.existsByCpf(novoUsuario.getCpf())){
            return ResponseEntity.status(404).build();
        }
        String email = novoUsuario.getEmail();
        novoUsuario.setHoraCadastro(LocalDateTime.now());
        if(email.contains("@valemobi.com")){
            novoUsuario.setFkEmpresa(1);
        } else if(email.contains("@accenture.com")){
            novoUsuario.setFkEmpresa(2);
        } else if(email.contains("@linx.com")){
            novoUsuario.setFkEmpresa(3);
        } else {
            novoUsuario.setFkEmpresa(0);
        }
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity login(@PathVariable String email,@PathVariable String senha){
        Usuario usuario = repository.findByEmailAndSenha(email,senha);
        if(usuario.getFkEmpresa() == 0){
            return ResponseEntity.status(404).build();
        }
        if(usuario == null){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuario);
    }


    @GetMapping("/empresa/{fkEmpresa}")
    public ResponseEntity getUsuarioByEmpresa(@PathVariable Integer fkEmpresa){
        List<Usuario> usuarios = repository.findByFkEmpresa(fkEmpresa);
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

}
