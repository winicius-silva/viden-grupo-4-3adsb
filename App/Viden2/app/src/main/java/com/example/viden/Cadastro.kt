package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.viden.models.Usuario
import com.example.viden.rest.Rest
import com.example.viden.services.UsuarioService
import java.time.LocalDateTime

class Cadastro : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etEmail: EditText
    private lateinit var etCPF: EditText
    private lateinit var etCelular: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmePassword: EditText
    private val retrofit = Rest.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        etNome = findViewById(R.id.et_nome)
        etEmail = findViewById(R.id.et_email)
        etCPF = findViewById(R.id.et_cpf)
        etCelular = findViewById(R.id.et_celular)
        etPassword = findViewById(R.id.et_password)
        etConfirmePassword = findViewById(R.id.et_confirme_password)
    }

    fun cadastrar(view: View){
        val usuarioRequest = retrofit.create(UsuarioService::class.java)
        val novoUsuario = Usuario(
            idUsuario = null,
            nomeUsuario = etNome.text.toString(),
            cpf = etCPF.text.toString(),
            celular = etCelular.text.toString(),
            email = etEmail.text.toString(),
            senha = etPassword.text.toString(),
            fkEmpresa = null,
            horaCadastro = "",
            horaLogin = ""
        )
        usuarioRequest.cadastrar(novoUsuario).execute()
    }

    fun voltar(view: View){
        startActivity(Intent(baseContext, MainActivity::class.java))
    }
}