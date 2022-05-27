package com.example.viden.services

import com.example.viden.models.UsuarioCurso
import retrofit2.Call
import retrofit2.http.*

interface UsuarioCursoService{

    @GET("/usuarios_cursos/recent-cursos/{fkUsuario}")
    fun getMyCurso(@Path("fkUsuario")fkUsuario: Int): Call<List<UsuarioCurso>>

    @POST("/usuarios_cursos/recent-cursos")
    fun postRecentCurso(@Body novoCurso: UsuarioCurso): Call<Void>

    @GET("/usuarios_cursos/cursos-finalizados/{fkUsuario}")
    fun getCursoFinalizados(@Path("fkUsuario")fkUsuario: Int): Call<List<UsuarioCurso>>

    @PATCH("/usuarios_cursos/progresso/{progresso}/{fkCurso}/{fkUsuario}")
    fun patchCursosFinalizados(@Path("progresso") progresso: Double,
                               @Path("fkCurso") fkCurso: Int,
                               @Path("fkUsuario") fkUsuario: Int): Call<Void>

    @GET("/usuarios_cursos/progresso/{fkCurso}/{fkUsuario}")
    fun getProgressoByUsuarioByCurso(@Path("fkCurso") fkCurso: Int,
                                     @Path("fkUsuario") fkUsuario: Int): Call<Double>
}
