package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);

    Boolean existsByEmail(String email);

    Boolean existsByCpf(String cpf);

}
