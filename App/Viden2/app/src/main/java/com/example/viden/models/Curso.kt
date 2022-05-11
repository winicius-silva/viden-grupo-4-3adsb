package com.example.viden.models

data class Curso(
    var idCurso: Int,
    var nomeCurso: String,
    var categoria: String,
    var subCategoria: String,
    var preco: Double,
    var descricao: String,
    var qtdPontos: Int,
    var cursoImg: String = ""
)
