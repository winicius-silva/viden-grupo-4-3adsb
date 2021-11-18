package com.viden.bandtec.videnws.resposta;

public class CursoSimplesResponse {

    private Integer idCurso;
    private String nomeCurso;
    private String descricao;

    public CursoSimplesResponse(Integer idCurso, String nomeCurso, String descricao) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }
}
