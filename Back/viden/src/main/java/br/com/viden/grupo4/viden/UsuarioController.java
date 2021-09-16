package br.com.viden.grupo4.viden;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/cadastrarPessoaFisica/{nome}/{cpf}/{telefone}/{email}/{senha}")
    public Boolean cadastrarPessoaFisica(@PathVariable String nome, @PathVariable String cpf, @PathVariable String telefone, @PathVariable String email, @PathVariable String senha){
        usuarios.add(new PessoaFisica(nome,telefone,email,senha,cpf));
        return true;
    }

    @GetMapping("/cadastrarPessoaJuridica/{nome}/{cnpj}/{telefone}/{email}/{senha}")
    public Boolean cadastrarPessoaJuridica(@PathVariable String nome, @PathVariable String cnpj, @PathVariable String telefone, @PathVariable String email, @PathVariable String senha){
        usuarios.add(new PessoaJuridica(nome,telefone,email,senha,cnpj));
        return true;
    }

    @GetMapping("/login/{email}/{senha}")
    public Boolean login(@PathVariable String email, @PathVariable String senha){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                usuario.setAutenticado(true);
                return true;
            }
        }
        return null;
    }

    @GetMapping("/logoff/{email}")
    public Boolean logoff(@PathVariable String email){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)){
                if(usuario.getAutenticado()){
                    usuario.setAutenticado(false);
                    return true;
                }
            }
        }
        return null;
    }

    @GetMapping("/getUsuarios")
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
}
