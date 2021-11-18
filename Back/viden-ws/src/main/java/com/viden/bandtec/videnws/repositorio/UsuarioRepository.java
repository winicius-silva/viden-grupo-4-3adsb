package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByIdusuario(Integer id_usuario);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.horaLogin = ?1 WHERE u.id_usuario = ?2")
    void updateHoraLogin(LocalDateTime novoHorario, Integer idUsuario);
}
