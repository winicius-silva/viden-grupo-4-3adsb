package com.viden.h2.bandtec.videnh2ws.repositorio;

import com.viden.h2.bandtec.videnh2ws.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByIdusuario(Integer id_usuario);
}
