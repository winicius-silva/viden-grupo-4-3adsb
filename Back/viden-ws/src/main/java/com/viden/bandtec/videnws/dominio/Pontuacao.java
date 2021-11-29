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

    @NotNull
    private Integer fkUsuario;

    @NotNull
    private Integer fkCurso;

    public Integer getIdPontosUsuario() {
        return idPontosUsuario;
    }

    public void setIdPontosUsuario(Integer idPontosUsuario) {
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
}
