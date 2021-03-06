package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.databinding.ActivityConcluirCursoBinding
import com.example.viden.fragment.Menu
import com.example.viden.models.Curso
import com.example.viden.models.Pontuacao
import com.example.viden.models.UsuarioCurso
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import com.example.viden.services.PontuacaoService
import com.example.viden.services.UsuarioCursoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConcluirCurso : AppCompatActivity() {

    private val retrofitCurso = Rest.getInstance().create(CursoService::class.java)
    private val retrofitUsuarioCurso = Rest.getInstance().create(UsuarioCursoService::class.java)
    private val retrofitPontuacao = Rest.getInstance().create(PontuacaoService::class.java)
    private lateinit var binding: ActivityConcluirCursoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concluir_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        supportFragmentManager.executePendingTransactions()
        binding = ActivityConcluirCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gerarCurso()
    }

    fun gerarCurso(){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        retrofitCurso.getOneCurso(cursoClicado!!).enqueue(object: Callback<Curso>{
            override fun onResponse(call: Call<Curso>, response: Response<Curso>) {
                if(response.isSuccessful){
                    binding.tvTituloCurso.text = response.body()?.nomeCurso
                    binding.tvRecompensa.text = response.body()?.qtdPontos.toString()
                    val imagem = when(response.body()?.categoria) {
                        "BACK-END" -> AppCompatResources.getDrawable(baseContext, R.drawable.backend)
                        "FRONT-END" -> AppCompatResources.getDrawable(baseContext, R.drawable.frontend)
                        "DEV-OPS" -> AppCompatResources.getDrawable(baseContext, R.drawable.devops)
                        "UI-UX" -> AppCompatResources.getDrawable(baseContext, R.drawable.uiux)
                        else -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_launcher_background)
                    }
                    binding.ivImageCurso.setImageDrawable(imagem)
                } else {
                    Toast.makeText(baseContext, "Erro ao carregar este curso", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Curso>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun irTrilhaCurso(view: View){
        startActivity(Intent(baseContext, TrilhaCurso::class.java))
    }

    fun finalizarCurso(view: View){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        val id = prefs?.getInt("id", 0)
        var visto = false
        retrofitUsuarioCurso.getMyCurso(id!!).enqueue(
            object: Callback<List<UsuarioCurso>>{
                override fun onResponse(
                    call: Call<List<UsuarioCurso>>,
                    response: Response<List<UsuarioCurso>>
                ) {
                    if(response.isSuccessful){
                        response.body()?.forEach { curso ->
                            if(curso == null){
                                visto = false
                            } else {
                                if(curso.fkCurso == cursoClicado){
                                    visto = true
                                }
                            }
                        }
                        if(visto){
                            verifyFinished()
                        } else {
                            Toast.makeText(baseContext, "Este curso nao foi iniciado!", Toast.LENGTH_LONG).show()
                        }
                    }
                }

                    override fun onFailure(call: Call<List<UsuarioCurso>>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                    }
                }
                )
    }


    fun verifyFinished(){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        val id = prefs?.getInt("id", 0)
        var finished = false
        retrofitUsuarioCurso.getCursoFinalizados(id!!).enqueue(
            object: Callback<List<UsuarioCurso>>{
                override fun onResponse(
                    call: Call<List<UsuarioCurso>>,
                    responseUsuarioCurso: Response<List<UsuarioCurso>>
                ) {
                    if(responseUsuarioCurso.isSuccessful){
                        responseUsuarioCurso.body()?.forEach { curso ->
                            if(curso == null){
                                finished = false
                            } else {
                                if(curso.fkCurso == cursoClicado){
                                    finished = true
                                    Toast.makeText(baseContext,
                                        "Esse curso ja foi finalizado!",
                                        Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                        if(!finished){
                            somarPontos()
                        }
                    } else {
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<UsuarioCurso>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    private fun somarPontos(){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        val id = prefs?.getInt("id", 0)
        val newPonto = Pontuacao (
            idPontosUsuario = null,
            data = null,
            pontos = binding.tvRecompensa.text.toString().toDouble(),
            fkUsuario = id!!,
            fkCurso = cursoClicado!!
        )
        retrofitPontuacao.postPontos(newPonto).enqueue(
            object: Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        Toast.makeText(baseContext, "Pontos foram somados :)", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
        retrofitUsuarioCurso.patchCursosFinalizados(100.0, cursoClicado, id).enqueue(
            object: Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        Toast.makeText(baseContext, "Curso Conclu??do com Sucesso!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(baseContext, MeusCursos::class.java))
                    } else {
                        Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

}