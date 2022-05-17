package com.example.viden.models

import java.time.LocalDate

data class UsuarioCurso (
    var idUsuarioCurso: Int,
    var fkUsuario: Int,
    var fkCurso: Int,
    var finalizado: Int,
    var date: String,
    var progresso: Double
)