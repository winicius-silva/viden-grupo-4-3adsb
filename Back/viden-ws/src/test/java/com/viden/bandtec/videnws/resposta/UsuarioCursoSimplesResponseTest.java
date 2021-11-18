package com.viden.bandtec.videnws.resposta;

import com.viden.bandtec.videnws.dominio.Curso;
import com.viden.bandtec.videnws.dominio.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioCursoSimplesResponseTest {

    @Test
    void construtorCursoEUsuario_iguaisNoNomeEId(){
        Curso curso = new Curso();
        curso.setNomeCurso("Ensinando Java");
        curso.setIdCurso(1);

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Winicius Silva");

        UsuarioCursoSimplesResponse response =
                new UsuarioCursoSimplesResponse(usuario,curso);

        assertEquals("Winicius Silva", usuario.getNomeUsuario());
        assertEquals("Ensinando Java", curso.getNomeCurso());
        assertEquals(1, curso.getIdCurso());

    }
}
