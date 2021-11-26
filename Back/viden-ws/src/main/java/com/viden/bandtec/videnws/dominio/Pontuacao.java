package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class Pontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPontosUsuario;

    @PastOrPresent
    private LocalDate data;

    @NotNull
    @Min(1)
    @Max(5)
    private Double pontos;

    @ManyToOne
    @JoinColumn(name="idUsuario", referencedColumnName="idusuario")
    @NotNull
    private Usuario fkUsuario;

    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName="idCurso")
    @NotNull
    private Curso fkCurso;

    public Pontuacao() {}

    public Pontuacao(Integer idPontosUsuario, LocalDate data, Double pontos, Usuario fkUsuario, Curso fkCurso) {
        this.idPontosUsuario = idPontosUsuario;
        this.data = data;
        this.pontos = pontos;
        this.fkUsuario = fkUsuario;
        this.fkCurso = fkCurso;
    }

    public Integer getIdPontosUsuario() {
        return idPontosUsuario;
    }

    public void setId_pontos_usuario(Integer idPontosUsuario) {
        this.idPontosUsuario = idPontosUsuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public Usuario getFkusuario() {
        return fkUsuario;
    }

    public void setFkusuario(Usuario fkusuario) {
        this.fkUsuario = fkusuario;
    }

    public Curso getFkcurso() {
        return fkCurso;
    }

    public void setFkcurso(Curso fkcurso) {
        this.fkCurso = fkcurso;
    }
}
