package com.example.viden.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viden.MeusCursos
import com.example.viden.MinhaConta
import com.example.viden.Pesquisa
import com.example.viden.R
import com.example.viden.databinding.MenuLayoutBinding

class Menu: Fragment(R.layout.menu_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.img_meus_cursos).setOnClickListener {
            irMeusCursos()
        }
        view.findViewById<ImageView>(R.id.img_pesquisa).setOnClickListener {
            irPesquisa()
        }
        view.findViewById<ImageView>(R.id.img_ranking).setOnClickListener {
            irRanking()
        }
        view.findViewById<ImageView>(R.id.img_perfil).setOnClickListener {
            irMinhaConta()
        }
    }

    fun irMeusCursos(){
        startActivity(Intent(this.context, MeusCursos::class.java))
    }

    fun irPesquisa(){
        startActivity(Intent(this.context, Pesquisa::class.java))
    }

    fun irRanking(){
        Toast.makeText(this.context, "Tela em produção, tente novamente mais tarde!",
            Toast.LENGTH_SHORT).show()
    }

    fun irMinhaConta(){
        startActivity(Intent(this.context, MinhaConta::class.java))
    }
}