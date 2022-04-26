package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TermosDeUso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_termos_de_uso)
    }

    fun voltar(view: View){
        startActivity(Intent(baseContext, Cadastro::class.java))
    }
}