package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.viden.models.Usuario
import com.example.viden.rest.Rest
import com.example.viden.services.UsuarioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        if(validarCampos()){
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
            usuarioRequest.cadastrar(novoUsuario).enqueue(object: Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        Toast.makeText(baseContext,
                            "Usuario cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                        startActivity(Intent(baseContext, Login::class.java))
                    } else {
                        Toast.makeText(baseContext,
                            "Algo deu errado, tente novamente mais tarde!", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    fun irTermos(view: View){
        startActivity(Intent(baseContext, TermosDeUso::class.java))
    }

    fun voltar(view: View){
        startActivity(Intent(baseContext, MainActivity::class.java))
    }

    private fun validarCampos(): Boolean {
        if(etNome.text.isNullOrEmpty()){
            etNome.error = "Preencha esse campo!"
            return false
        } else if(etCPF.text.isNullOrEmpty()){
            etCPF.error = "Preencha esse campo!"
            return false
        } else if(etCelular.text.isNullOrEmpty()){
            etCelular.error = "Preencha esse campo!"
            return false
        } else if(etPassword.text.isNullOrEmpty()){
            etPassword.error = "Preencha esse campo!"
            return false
        } else if(etPassword.text.length < 8){
            etPassword.error = "A senha precisa conter 8 digitos"
            return false
        } else if(etConfirmePassword.text.isNullOrEmpty()){
            etConfirmePassword.error = "Preencha esse campo!"
            return false
        } else if(!etPassword.equals(etConfirmePassword)){
            etConfirmePassword.error = "Senha não estão corretar"
            return false
        } else if(etEmail.text.isNullOrEmpty()){
            etEmail.error = "Preencha esse campo!"
            return false
        } else if(!etEmail.text.toString().contains("@")){
            etEmail.error = "Campo precisa de '@'"
            return false
        }
        return true
    }
}