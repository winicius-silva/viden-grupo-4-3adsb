package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class TrilhaCurso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trilha_curso)
    }

    fun irMeusCursosCurso(view: View){
        startActivity(Intent(baseContext, MeusCursosCurso::class.java))
    }

    fun irConcluirCurso(view: View){
        startActivity(Intent(baseContext, ConcluirCurso::class.java))
    }

    fun irMeusCursos(view: View){
        startActivity(Intent(baseContext, MeusCursos::class.java))
    }

    fun irPesquisa(view: View){
        startActivity(Intent(baseContext, Pesquisa::class.java))
    }

    fun irRanking(view: View){
        Toast.makeText(baseContext, "Tela em produção, tente novamente mais tarde!",
            Toast.LENGTH_SHORT).show()
    }

    fun irMinhaConta(view: View){
        startActivity(Intent(baseContext, MinhaConta::class.java))
    }
}