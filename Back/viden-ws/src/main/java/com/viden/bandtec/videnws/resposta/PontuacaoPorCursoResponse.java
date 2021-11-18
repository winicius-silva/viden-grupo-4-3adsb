package com.viden.bandtec.videnws.resposta;

import com.viden.bandtec.videnws.dominio.Curso;

public class PontuacaoPorCursoResponse {

    private String nomeCurso;
    private Double pontos;

    public PontuacaoPorCursoResponse(Curso curso, Double pontos) {
        this.nomeCurso = curso.getNomeCurso();
        this.pontos = pontos;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public Double getPontos() {
        return pontos;
    }
}
