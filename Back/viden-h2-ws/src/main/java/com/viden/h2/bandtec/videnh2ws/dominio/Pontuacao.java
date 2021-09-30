package com.viden.h2.bandtec.videnh2ws.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pontos_usuario;
    private Integer data;
    private Double pontos;
    private Integer fkusuario;
    private Integer fkcurso;

    public Integer getId_pontos_usuario() {
        return id_pontos_usuario;
    }

    public void setId_pontos_usuario(Integer id_pontos_usuario) {
        this.id_pontos_usuario = id_pontos_usuario;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public Integer getFk_usuario() {
        return fkusuario;
    }

    public void setFk_usuario(Integer fk_usuario) {
        this.fkusuario = fk_usuario;
    }

    public Integer getFk_curso() {
        return fkcurso;
    }

    public void setFk_curso(Integer fk_curso) {
        this.fkcurso = fk_curso;
    }
}
