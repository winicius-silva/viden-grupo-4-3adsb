package com.viden.h2.bandtec.videnh2ws.repositorio;

import com.viden.h2.bandtec.videnh2ws.dominio.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Integer> {

    List<Pontuacao> findAllByFkusuario(Integer fk_usuario);
}
