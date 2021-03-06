package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


public interface UsuarioCursoRepository extends JpaRepository<UsuarioCurso, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioCurso u SET u.finalizado = ?1 WHERE u.fkCurso = ?2 AND u.fkUsuario = ?3")
    void atualizarFinalizado(Integer finalizado, Integer fkCurso, Integer fkUsuario);

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioCurso u SET u.progresso = ?1 WHERE u.fkCurso = ?2 AND u.fkUsuario = ?3")
    void atualizarProgresso(Double progresso, Integer fkCurso, Integer fkUsuario);

    boolean existsByFkCursoAndFkUsuario(Integer fkCurso, Integer fkUsuario);

    UsuarioCurso findByFkCursoAndFkUsuario(Integer fkCurso, Integer fkUsuario);

    @Transactional
    @Modifying
    @Query("UPDATE UsuarioCurso u SET u.date = ?1 WHERE u.fkCurso = ?2 AND u.fkUsuario = ?3")
    void atualizarDate(LocalDate date, Integer fkCurso, Integer fkUsuario);
}
