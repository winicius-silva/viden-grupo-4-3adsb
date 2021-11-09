package com.viden.bandtec.videnws.dominio;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class EmpresaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresaCurso;

    @ManyToOne
    @NotNull
    private Empresa fkEmpresa;

    @ManyToOne
    @javax.validation.constraints.NotNull
    private Curso fkCurso;

    @PastOrPresent
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
