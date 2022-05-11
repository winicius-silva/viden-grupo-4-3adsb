package com.example.viden.services

import com.example.viden.models.Empresa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmpresaService {

    @GET("/empresas/{idEmpresa}")
    fun getEmpresaById(@Path("idEmpresa") idEmpresa: Int): Call<Empresa>
}