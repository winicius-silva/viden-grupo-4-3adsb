package com.viden.bandtec.videnws.resposta;

import com.viden.bandtec.videnws.dominio.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PontuacaoPorCursoResponseTest {

    @Test
    void construtorVirNomeDoCurso_ePontuacao(){
        Curso curso = new Curso();
        curso.setNomeCurso("Teste");
        PontuacaoPorCursoResponse response =
                new PontuacaoPorCursoResponse(curso, 4.0);

        assertEquals("Teste", response.getNomeCurso());
        assertEquals(4.0,response.getPontos());
    }
}
