package br.com.viden.grupo4.viden;

public class Pontuacao {

    private Integer data;
    private Double pontos;
    private Integer fk_curso;
    private Integer fk_usuario;

    public Pontuacao(Integer data, Double pontos, Integer fk_curso, Integer fk_usuario) {
        this.data = data;
        this.pontos = pontos;
        this.fk_curso = fk_curso;
        this.fk_usuario = fk_usuario;
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

    public Integer getfk_curso() {
        return fk_curso;
    }

    public void setfk_curso(Integer fk_curso) {
        this.fk_curso = fk_curso;
    }

    public Integer getfk_usuario() {
        return fk_usuario;
    }

    public void setfk_usuario(Integer fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
}
