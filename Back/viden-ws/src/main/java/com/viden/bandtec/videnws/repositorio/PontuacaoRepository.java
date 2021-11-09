package com.viden.bandtec.videnws.repositorio;

import com.viden.bandtec.videnws.dominio.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Integer> {

    List<Pontuacao> findAllByFkUsuario(Integer fkUsuario);
}
