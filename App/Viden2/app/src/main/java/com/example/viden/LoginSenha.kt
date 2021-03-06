package com.example.viden

import android.content.Context
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

class LoginSenha : AppCompatActivity() {

    private lateinit var email: String
    private lateinit var etSenha: EditText
    private val retrofit = Rest.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_senha)
        email = intent.getStringExtra("email").toString()
        etSenha = findViewById(R.id.et_senha)
    }

    fun login(view: View){
        val senha = etSenha.text.toString()
        val usuarioRequest = retrofit.create(UsuarioService::class.java)
        usuarioRequest.login(email, senha).enqueue(
            object: Callback<Usuario>{
                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if(response.isSuccessful){
                        val editor = getSharedPreferences(
                            "USER",
                            Context.MODE_PRIVATE
                        ).edit()
                        editor.putInt("id", response.body()?.idUsuario!!)
                        editor.putInt("fkEmpresa", response.body()?.fkEmpresa!!)
                        editor.apply()
                        startActivity(Intent(baseContext, MeusCursos::class.java))
                    } else {
                        Toast.makeText(baseContext, "Usuario ou senha invalidos!"
                            , Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    fun voltar(view: View){
        startActivity(Intent(baseContext, Login::class.java))
    }

}