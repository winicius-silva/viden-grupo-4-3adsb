package com.example.viden

import android.content.Context
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

    fun irMeusDados(view: View){
        startActivity(Intent(baseContext, MeusDados::class.java))
    }

    fun irSobreNos(view: View){
        startActivity(Intent(baseContext, SobreNos::class.java))
    }

    fun irRedesSociais(view: View){
        startActivity(Intent(baseContext, RedesSociais::class.java))
    }

    fun sair(view: View){
        val editor = getSharedPreferences(
            "USER",
            Context.MODE_PRIVATE
        ).edit()
        editor.putInt("id", 0)
        editor.apply()
        startActivity(Intent(baseContext, MainActivity::class.java))
    }
}