package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.fragment.Menu

class Pesquisa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
    }

    fun irPesquisaCurso(view: View){
        startActivity(Intent(baseContext, PesquisaCurso::class.java))
    }
}