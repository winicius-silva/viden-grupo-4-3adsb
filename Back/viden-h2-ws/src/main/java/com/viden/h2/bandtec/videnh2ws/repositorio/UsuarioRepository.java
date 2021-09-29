package com.viden.h2.bandtec.videnh2ws.repositorio;

import com.viden.h2.bandtec.videnh2ws.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);
}
