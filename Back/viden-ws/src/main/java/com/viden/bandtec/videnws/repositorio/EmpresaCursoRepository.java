package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.EmpresaCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaCursoRepository extends JpaRepository<EmpresaCurso, Integer> {

    List<EmpresaCurso> findByIdEmpresa(Integer idEmpresa);
}
