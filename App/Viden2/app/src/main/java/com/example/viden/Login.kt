package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Login : AppCompatActivity() {

    private lateinit var etEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.et_email)
    }

    fun passarTelaSenha(view: View){
        if(validarEmail()){
            val telaLoginSenha = Intent(baseContext, LoginSenha::class.java)
            telaLoginSenha.putExtra("email", etEmail.text.toString())
            startActivity(telaLoginSenha)
        }
    }

    fun voltar(view: View){
        startActivity(Intent(baseContext, MainActivity::class.java))
    }

    fun passarTelaCadastro(view: View){
        startActivity(Intent(baseContext, Cadastro::class.java))
    }

    private fun validarEmail(): Boolean{
        if(etEmail.text.isNullOrEmpty()){
            etEmail.error = "Preencha seu email!"
            return false
        } else if(!etEmail.text.toString().contains("@")){
            etEmail.error = "Campo precisa de '@'"
            return false
        }
        return true
    }
}