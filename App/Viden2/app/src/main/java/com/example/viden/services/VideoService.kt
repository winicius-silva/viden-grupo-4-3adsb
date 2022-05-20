package com.example.viden.services

import com.example.viden.models.Video
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoService {

    @GET("/video-curso/{fkCurso}")
    fun getVideosByCurso(@Path("fkCurso")fkCurso: Int): Call<List<Video>>

    @GET("/video-curso/{indice}/{fkCurso}")
    fun getIndiceVideoByCurso(@Path("indice") indice: Int,
                             @Path("fkCurso")fkCurso: Int): Call<Video>

}
