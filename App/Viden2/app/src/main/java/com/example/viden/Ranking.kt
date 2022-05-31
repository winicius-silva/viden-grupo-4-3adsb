package com.example.viden

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.databinding.ActivityRankingBinding
import com.example.viden.fragment.Loading
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

class Ranking : AppCompatActivity() {

    private val retrofitUsuario = Rest.getInstance().create(UsuarioService::class.java)
    private val retrofitPontuacao = Rest.getInstance().create(PontuacaoService::class.java)
    private val retrofitEmpresa = Rest.getInstance().create(EmpresaService::class.java)
    private lateinit var binding: ActivityRankingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        supportFragmentManager.executePendingTransactions()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Loading>(R.id.containerFragmentLoading)
        }
        supportFragmentManager.executePendingTransactions()
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNomeEmpresa()
        getUsuarioEmpresa()
        getUsuarioViden()
    }

    fun getNomeEmpresa(){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val fkEmpresa = prefs?.getInt("fkEmpresa", 0)
        retrofitEmpresa.getEmpresaById(fkEmpresa!!).enqueue(
            object: Callback<Empresa>{
                override fun onResponse(call: Call<Empresa>, response: Response<Empresa>) {
                    if(response.isSuccessful){
                        binding.tvNomeEmpresa.text = response.body()?.nome
                    } else {
                        Toast.makeText(baseContext,
                            "Não conseguimos buscar a empresa",
                            Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Empresa>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

            }
        )
    }

    fun getUsuarioEmpresa(){
        val listUsuario: MutableList<Int> = mutableListOf()
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val fkEmpresa = prefs?.getInt("fkEmpresa", 0)
        retrofitUsuario.getUsuariosByEmpresa(fkEmpresa!!).enqueue(
            object: Callback<List<Usuario>>{
                override fun onResponse(
                    call: Call<List<Usuario>>,
                    response: Response<List<Usuario>>
                ) {
                    if(response.isSuccessful){
                        response.body()?.forEach { usuario ->
                            if(usuario == null){
                                Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                            } else {
                                listUsuario.add(usuario.idUsuario!!)
                            }
                        }
                        if(!listUsuario.isNullOrEmpty()){
                            getRankingEmpresa(listUsuario)
                        }
                    } else {
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    fun getRankingEmpresa(listUsuario: List<Int>){
        val listUsuarioString = listUsuario.toString().substringAfter("[").substringBefore("]")
        retrofitPontuacao.getTotalByUsuarios(listUsuarioString).enqueue(
            object: Callback<List<Pontuacao>>{
                override fun onResponse(
                    call: Call<List<Pontuacao>>,
                    response: Response<List<Pontuacao>>
                ) {
                    if(response.isSuccessful){
                        if(response.body() != null){
                            val list = response.body()!!.sortedByDescending { it.pontos }.take(5)
                            binding.tvPontos1.text = list[0].pontos.toString()
                            getNome(list[0].fkUsuario, binding.tvNome1)

                            if(response.body()?.size!! > 1){
                                binding.tvPontos2.text = list[1].pontos.toString()
                                getNome(list[1].fkUsuario, binding.tvNome2)
                            }

                            if(response.body()?.size!! > 2){
                                binding.tvPontos3.text = list[2].pontos.toString()
                                getNome(list[2].fkUsuario, binding.tvNome3)
                            }

                            if(response.body()?.size!! > 3){
                                binding.tvPontos4.text = list[3].pontos.toString()
                                getNome(list[3].fkUsuario, binding.tvNome4)
                            }

                            if(response.body()?.size!! > 4){
                                binding.tvPontos5.text = list[4].pontos.toString()
                                getNome(list[4].fkUsuario, binding.tvNome5)
                            }
                        }
                    } else {
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<Pontuacao>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    fun getUsuarioViden(){
        val listUsuario: MutableList<Int> = mutableListOf()
        retrofitUsuario.getAllUsuarios().enqueue(
            object: Callback<List<Usuario>>{
                override fun onResponse(
                    call: Call<List<Usuario>>,
                    response: Response<List<Usuario>>
                ) {
                    if(response.isSuccessful){
                        response.body()?.forEach { usuario ->
                            if(usuario == null){
                                Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                            } else {
                                listUsuario.add(usuario.idUsuario!!)
                            }
                        }
                        if(!listUsuario.isNullOrEmpty()){
                            getRankingViden(listUsuario)
                        }
                    } else {
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    fun getRankingViden(listUsuario: List<Int>){
        val listUsuarioString = listUsuario.toString().substringAfter("[").substringBefore("]")
        retrofitPontuacao.getTotalByUsuarios(listUsuarioString).enqueue(
            object: Callback<List<Pontuacao>>{
                override fun onResponse(
                    call: Call<List<Pontuacao>>,
                    response: Response<List<Pontuacao>>
                ) {
                    if(response.isSuccessful){
                        if(response.body() != null){
                            val list = response.body()!!.sortedByDescending { it.pontos }.take(5)
                            binding.tvVidenPontos1.text = list[0].pontos.toString()
                            getNome(list[0].fkUsuario, binding.tvVidenNome1)

                            if(response.body()?.size!! > 1){
                                binding.tvVidenPontos2.text = list[1].pontos.toString()
                                getNome(list[1].fkUsuario, binding.tvVidenNome2)
                            }

                            if(response.body()?.size!! > 2){
                                binding.tvVidenPontos3.text = list[2].pontos.toString()
                                getNome(list[2].fkUsuario, binding.tvVidenNome3)
                            }

                            if(response.body()?.size!! > 3){
                                binding.tvVidenPontos4.text = list[3].pontos.toString()
                                getNome(list[3].fkUsuario, binding.tvVidenNome4)
                            }

                            if(response.body()?.size!! > 4){
                                binding.tvVidenPontos5.text = list[4].pontos.toString()
                                getNome(list[4].fkUsuario, binding.tvVidenNome5)
                            }
                            binding.containerFragmentLoading.isVisible = false
                        }
                    } else {
                        binding.containerFragmentLoading.isVisible = false
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<Pontuacao>>, t: Throwable) {
                    binding.containerFragmentLoading.isVisible = false
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    private fun getNome(idUsuario: Int?, textView: TextView) {
        if(idUsuario != null){
            retrofitUsuario.getUsuario(idUsuario).enqueue(
                object: Callback<Usuario>{
                    override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                        if(response.isSuccessful){
                            textView.text = response.body()?.nomeUsuario.toString()
                        } else {
                            Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<Usuario>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                    }
                }
            )
        }
    }

}