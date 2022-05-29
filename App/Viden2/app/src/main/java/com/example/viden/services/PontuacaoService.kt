package com.example.viden.services

import com.example.viden.models.Pontuacao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PontuacaoService {

    @POST("/pontuacoes")
    fun postPontos(@Body novoPonto: Pontuacao): Call<Void>

    @GET("/pontuacoes/{fkUsuario}")
    fun getPontosPorUsuario(@Path("fkUsuario")fkUsuario: Int): Call<List<Pontuacao>>

    @GET("/pontuacoes/total/{fkUsuario}")
    fun getPontosTotalPorUsuario(@Path("fkUsuario")fkUsuario: Int): Call<Pontuacao>

    @GET("/pontuacoes/total_usuarios/{usuarios}")
    fun getTotalByUsuarios(@Path("usuarios") usuarios: String): Call<List<Pontuacao>>

}