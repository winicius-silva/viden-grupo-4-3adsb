package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class UsuarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuarioCurso;

    @ManyToOne
    @NotNull
    private Usuario fkUsuario;

    @ManyToOne
    @NotNull
    private Curso fkCurso;

    @Min(0)
    @Max(1)
    private Integer finalizado;

    @PastOrPresent
    private LocalDate date;

    @NotNull
    private Double progresso;

    public Integer getIdUsuarioCurso() {
        return idUsuarioCurso;
    }

    public void setIdUsuarioCurso(Integer idUsuarioCurso) {
        this.idUsuarioCurso = idUsuarioCurso;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
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
