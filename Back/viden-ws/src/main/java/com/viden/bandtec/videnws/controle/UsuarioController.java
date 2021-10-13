package com.viden.bandtec.videnws.controle;

import com.viden.bandtec.videnws.dominio.Usuario;
import com.viden.bandtec.videnws.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getUsuario(){
        return repository.findAll();
    }

    @GetMapping("/{id_usuario}")
    public Usuario getUsuario(@PathVariable Integer id_usuario){
        return repository.findByIdusuario(id_usuario);
    }

    @PostMapping
    public String cadastrar(@RequestBody Usuario novoUsuario){
        repository.save(novoUsuario);
        return "Usuario cadastrado com sucesso!";
    }

    @GetMapping("/login/{email}/{senha}")
    public Boolean login(@PathVariable String email,@PathVariable String senha){
        Usuario usuarios = repository.findByEmailAndSenha(email,senha);
        if(usuarios == null){
            return false;
        }
        return true;
    }

}
