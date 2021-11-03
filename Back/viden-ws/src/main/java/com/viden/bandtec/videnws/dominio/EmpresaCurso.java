package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EmpresaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresaCurso;
    @ManyToOne
    private Empresa fkEmpresa;
    @ManyToOne
    private Curso fkCurso;
    private LocalDate data;

    public Integer getIdEmpresaCurso() {
        return idEmpresaCurso;
    }

    public void setIdEmpresaCurso(Integer idEmpresaCurso) {
        this.idEmpresaCurso = idEmpresaCurso;
    }

    public Empresa getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Empresa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
        this.fkCurso = fkCurso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
