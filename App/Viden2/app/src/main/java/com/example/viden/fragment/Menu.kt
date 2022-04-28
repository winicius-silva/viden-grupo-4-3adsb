package com.example.viden.fragment

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viden.MeusCursos
import com.example.viden.MinhaConta
import com.example.viden.Pesquisa
import com.example.viden.R

class Menu: Fragment(R.layout.menu_layout) {

    fun irMeusCursos(view: View){
        startActivity(Intent(this.context, MeusCursos::class.java))
    }

    fun irPesquisa(view: View){
        startActivity(Intent(this.context, Pesquisa::class.java))
    }

    fun irRanking(view: View){
        Toast.makeText(this.context, "Tela em produção, tente novamente mais tarde!",
            Toast.LENGTH_SHORT).show()
    }

    fun irMinhaConta(view: View){
        startActivity(Intent(this.context, MinhaConta::class.java))
    }
}