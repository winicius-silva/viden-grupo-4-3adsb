package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.VideoCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoCursoRepository extends JpaRepository<VideoCurso, Integer> {

    List<VideoCurso> findByIdCurso(Integer id);
}
