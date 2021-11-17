package com.viden.bandtec.videnws.resposta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CursoSimplesResponseTest {

    @Test
    void construtorIdCurso_devePreencherIdCurso(){
        CursoSimplesResponse response =
                new CursoSimplesResponse(1,"Ensinando Java", "teste");

        assertEquals(1, response.getIdCurso());
        assertEquals("Ensinando Java", response.getNomeCurso());
        assertEquals("teste", response.getDescricao());

    }
}
