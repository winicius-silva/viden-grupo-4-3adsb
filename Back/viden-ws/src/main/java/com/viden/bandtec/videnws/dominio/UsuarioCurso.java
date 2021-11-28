package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class UsuarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuarioCurso;

    @NotNull
    private Integer fkUsuario;

    @NotNull
    private Integer fkCurso;

    @Min(0)
    @Max(1)
    private Integer finalizado;

    @NotNull
    private LocalDate date;

    @NotNull
    @Min(0)
    @Max(100)
    private Double progresso;

    public Integer getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public void setIdUsuarioCurso(Integer idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Integer fkCurso) {
        this.fkCurso = fkCurso;
    }

    public Integer getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Integer finalizado) {
        this.finalizado = finalizado;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getProgresso() {
        return progresso;
    }

    public void setProgresso(Double progresso) {
        this.progresso = progresso;
    }
}
