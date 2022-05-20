package com.example.viden.models

data class Video(
    var idVideoCurso: Int,
    var fkCurso: Int,
    var link: String,
    var titulo: String,
    var descricaoVideo: String,
    var indice: Int
)