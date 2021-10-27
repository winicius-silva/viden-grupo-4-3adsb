package com.viden.bandtec.videnws.dominio;

import javax.persistence.*;

@Entity
@Table(name = "tb_curso")
public class UsuarioCurso {

    @Column(name = "fk_usuario")
    private Integer fkUsuario;

    @Column(name = "fk_curso")
    private Integer fkCurso;


    @Column(name = "finalizado")
    private Integer finalizado;
// aqui temos 1 para true e 0 para false, estamos usando assim pq o banco não aceita true e false

    @Column(name = "date")
    private Integer date;

    @Column(name = "progresso")
    private Double progresso;

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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getProgresso() {
        return progresso;
    }

    public void setProgresso(Double progresso) {
        this.progresso = progresso;
    }
}
