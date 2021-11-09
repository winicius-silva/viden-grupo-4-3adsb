package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioCursoRepository extends JpaRepository<UsuarioCurso, Integer> {

    List<UsuarioCurso> findByFkUsuarioAndDateGreaterThan(Integer idUsuario, LocalDate date);
}
