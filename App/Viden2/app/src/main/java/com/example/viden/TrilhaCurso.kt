package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.fragment.Menu

class TrilhaCurso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trilha_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
    }

    fun irMeusCursosCurso(view: View){
        startActivity(Intent(baseContext, MeusCursosCurso::class.java))
    }

    fun irConcluirCurso(view: View){
        startActivity(Intent(baseContext, ConcluirCurso::class.java))
    }

}