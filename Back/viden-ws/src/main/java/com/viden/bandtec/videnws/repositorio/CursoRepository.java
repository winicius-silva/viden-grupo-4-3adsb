package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    List<Curso> findByCategoria(String categoria);

    List<Curso> findByNomeCursoLike(String nome);

    List<Curso> findBySubCategoria(String subCategoria);


}
