package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.fragment.Menu

class MinhaConta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_conta)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
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

    fun irMeusDados(view: View){
        startActivity(Intent(baseContext, MeusDados::class.java))
    }

    fun irSobreNos(view: View){
        startActivity(Intent(baseContext, SobreNos::class.java))
    }

    fun irRedesSociais(view: View){
        startActivity(Intent(baseContext, RedesSociais::class.java))
    }
}