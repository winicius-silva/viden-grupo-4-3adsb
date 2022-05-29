package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        if (prefs != null) {
            startActivity(Intent(baseContext, MeusCursos::class.java))
        }
    }

    fun entrar(view: View){
        startActivity(Intent(baseContext, Login::class.java))
    }

    fun cadastro(view: View){
        startActivity(Intent(baseContext, Cadastro::class.java))
    }
}