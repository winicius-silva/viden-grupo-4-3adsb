package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Pontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPontosUsuario;
    private LocalDate data;
    private Double pontos;
    @ManyToOne
    private Usuario fkUsuario;
    @ManyToOne
    private Curso fkCurso;

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
