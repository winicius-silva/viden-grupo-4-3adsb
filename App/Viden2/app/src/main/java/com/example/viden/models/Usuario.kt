package com.example.viden.models


data class Usuario(
    var idUsuario: Int?,
    var nomeUsuario: String,
    var cpf: String,
    var celular: String,
    var email: String,
    var senha: String,
    var fkEmpresa: Int?,
    var horaCadastro: String,
    var horaLogin: String
)
