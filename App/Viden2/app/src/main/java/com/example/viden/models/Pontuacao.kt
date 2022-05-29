package com.example.viden.models

data class Pontuacao(
    var idPontosUsuario: Int?,
    var data: String?,
    var pontos: Double,
    var fkUsuario: Int,
    var fkCurso: Int
)
