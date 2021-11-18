package com.viden.bandtec.videnws.resposta;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.dominio.Usuario;

public class UsuarioCursoSimplesResponse {

    private String nomeUsuario;
    private Integer idCurso;
    private String nomeCurso;

    public UsuarioCursoSimplesResponse(Usuario usuario, Curso curso) {
        this.nomeUsuario = usuario.getNomeUsuario();
        this.idCurso = curso.getIdCurso();
        this.nomeCurso = curso.getNomeCurso();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
}
