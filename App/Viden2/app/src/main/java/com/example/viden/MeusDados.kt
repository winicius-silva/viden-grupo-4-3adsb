package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.fragment.Menu
import com.example.viden.models.Empresa
import com.example.viden.models.Usuario
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import com.example.viden.services.EmpresaService
import com.example.viden.services.UsuarioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeusDados : AppCompatActivity() {

    private val retrofitUsuario = Rest.getInstance().create(UsuarioService::class.java)
    private val retrofitEmpresa = Rest.getInstance().create(EmpresaService::class.java)
    private lateinit var tvNome: TextView
    private lateinit var tvEmpresa: TextView
    private lateinit var tvCPF: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvTelefone: TextView
    private lateinit var tvCoins: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_dados)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        tvNome = findViewById(R.id.tv_nome)
        tvEmpresa = findViewById(R.id.tv_empresa)
        tvCPF = findViewById(R.id.tv_cpf)
        tvEmail = findViewById(R.id.tv_email)
        tvTelefone = findViewById(R.id.tv_telefone)
        tvCoins = findViewById(R.id.tv_coins)
    }

    fun getDados(){
        val prefs = getSharedPreferences("ID", Context.MODE_PRIVATE)
        val id = prefs?.getInt("id", 0)
        retrofitUsuario.getUsuario(id!!).enqueue(object: Callback<Usuario>{
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if(response.isSuccessful){
                    tvNome.text = response.body()?.nomeUsuario
                    tvCPF.text = response.body()?.cpf
                    tvEmail.text = response.body()?.email
                    tvTelefone.text = response.body()?.celular
                    retrofitEmpresa.getEmpresaById(response.body()?.fkEmpresa!!)
                        .enqueue(object: Callback<Empresa>{
                            override fun onResponse(
                                call: Call<Empresa>,
                                responseEmpresa: Response<Empresa>
                            ) {
                                if(responseEmpresa.isSuccessful){
                                    tvEmpresa.text = responseEmpresa.body()?.nome
                                }
                            }

                            override fun onFailure(call: Call<Empresa>, t: Throwable) {
                                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                            }

                        })
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun irMinhaConta(view: View){
        startActivity(Intent(baseContext, MinhaConta::class.java))
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

}