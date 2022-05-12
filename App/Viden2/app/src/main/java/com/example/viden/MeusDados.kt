package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.databinding.ActivityMeusDadosBinding
import com.example.viden.fragment.Menu
import com.example.viden.models.Empresa
import com.example.viden.models.Pontuacao
import com.example.viden.models.Usuario
import com.example.viden.rest.Rest
import com.example.viden.services.EmpresaService
import com.example.viden.services.PontuacaoService
import com.example.viden.services.UsuarioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeusDados : AppCompatActivity() {

    private val retrofitUsuario = Rest.getInstance().create(UsuarioService::class.java)
    private val retrofitEmpresa = Rest.getInstance().create(EmpresaService::class.java)
    private val retrofitPontuacao = Rest.getInstance().create(PontuacaoService::class.java)
    private lateinit var binding: ActivityMeusDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeusDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        getDados()
    }


    fun getDados() {
        val prefs = getSharedPreferences("ID", Context.MODE_PRIVATE)
        val id = prefs.getInt("id", 0)
        retrofitUsuario.getUsuario(id).enqueue(object : Callback<Usuario> {
//            binding.prograbasodkasdoka = View.VISIBLE
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    binding.tvNome.text = response.body()?.nomeUsuario
                    binding.tvCpf.text = response.body()?.cpf
                    binding.tvEmail.text = response.body()?.email
                    binding.tvTelefone.text = response.body()?.celular
                    retrofitEmpresa.getEmpresaById(response.body()?.fkEmpresa!!)
                        .enqueue(object : Callback<Empresa> {
                            override fun onResponse(
                                call: Call<Empresa>,
                                responseEmpresa: Response<Empresa>
                            ) {
                                if (responseEmpresa.isSuccessful) {
                                    binding.tvEmpresa.text = responseEmpresa.body()?.nome
                                }
                            }

                            override fun onFailure(call: Call<Empresa>, t: Throwable) {
                                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                            }

                        })
                    retrofitPontuacao.getPontosTotalPorUsuario(id!!)
                        .enqueue(object : Callback<Pontuacao> {
                            override fun onResponse(
                                call: Call<Pontuacao>,
                                responsePontuacao: Response<Pontuacao>
                            ) {
//                                biding.progresbass = VIEW.GONE
                                if (responsePontuacao.isSuccessful) {
                                    binding.tvCoins.text =
                                        responsePontuacao.body()?.pontos.toString()
                                }
                            }

                            override fun onFailure(call: Call<Pontuacao>, t: Throwable) {
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

}