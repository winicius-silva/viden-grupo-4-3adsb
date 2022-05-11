package com.example.viden.services

import com.example.viden.models.Curso
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CursoService {

    @GET("/cursos/{idCurso}")
    fun getOneCurso(@Path("idCurso")idCurso: Int): Call<Curso>

    @GET("/cursos/filter/{categoria}")
    fun getCursoCategoria(@Path("categoria")categoria: String): Call<List<Curso>>

    @GET("/cursos/search/{nomeCurso}")
    fun getCursosSearch(@Path("nomeCurso")nomeCurso: String): Call<List<Curso>>
}