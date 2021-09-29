package com.viden.h2.bandtec.videnh2ws.controle;

import com.viden.h2.bandtec.videnh2ws.dominio.Usuario;
import com.viden.h2.bandtec.videnh2ws.repositorio.UsuarioRepository;
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

    @PostMapping
    public String cadastrar(@RequestBody Usuario novoUsuario){
        repository.save(novoUsuario);
        return "Usuario cadastrado com sucesso!";
    }

    @GetMapping("/login/{email}/{senha}")
    public Boolean login(@PathVariable String email,@PathVariable String senha){
        List<Usuario> usuarios = repository.findAll();
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
}
