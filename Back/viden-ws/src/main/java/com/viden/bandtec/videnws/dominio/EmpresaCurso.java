package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class EmpresaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresaCurso;

    @NotNull
    private Integer fkEmpresa;

    @NotNull
    private Integer fkCurso;

    @PastOrPresent
    private LocalDate data;

    public Integer getIdEmpresaCurso() {
        return idEmpresaCurso;
    }

    public void setIdEmpresaCurso(Integer idEmpresaCurso) {
        this.idEmpresaCurso = idEmpresaCurso;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Integer fkCurso) {
        this.fkCurso = fkCurso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
