package com.example.viden.models

data class Empresa(
    var idEmpresa: Int,
    var nome: String,
    var cnpj: String,
    var endereco: String,
    var email: String,
    var duracaoDoContrato: String,
    var valorDoContrato: Double
)
