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
import com.example.viden.databinding.ActivityMeusCursosCursoBinding
import com.example.viden.fragment.Menu
import com.example.viden.models.Curso
import com.example.viden.models.UsuarioCurso
import com.example.viden.models.Video
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import com.example.viden.services.UsuarioCursoService
import com.example.viden.services.VideoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeusCursosCurso : AppCompatActivity() {

    private val retrofitCurso = Rest.getInstance().create(CursoService::class.java)
    private val retrofitUsuarioCurso = Rest.getInstance().create(UsuarioCursoService::class.java)
    private lateinit var binding: ActivityMeusCursosCursoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_cursos_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        supportFragmentManager.executePendingTransactions()
        binding = ActivityMeusCursosCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gerarDadosCurso()
    }

    fun irMeusCursos(view: View){
        startActivity(Intent(baseContext, MeusCursos::class.java))
    }

    fun gerarDadosCurso(){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val id = prefs?.getInt("id", 0)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        retrofitCurso.getOneCurso(cursoClicado!!).enqueue(object: Callback<Curso>{
            override fun onResponse(call: Call<Curso>, response: Response<Curso>) {
                if(response.isSuccessful){
                    binding.tvTitulo.text = response.body()?.nomeCurso.toString()
                    binding.tvDescricao.text = response.body()?.descricao.toString()
                    binding.tvPontos.text = response.body()?.qtdPontos.toString()
                    val imagem = when(response.body()?.categoria) {
                        "BACK-END" -> AppCompatResources.getDrawable(baseContext, R.drawable.backend)
                        "FRONT-END" -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_launcher_background)
                        else -> AppCompatResources.getDrawable(baseContext, R.drawable.ic_launcher_background)
                    }
                    binding.ivImagemCurso.setImageDrawable(imagem)
                }
            }

            override fun onFailure(call: Call<Curso>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

        retrofitUsuarioCurso.getProgressoByUsuarioByCurso(cursoClicado, id!!).enqueue(object: Callback<Double>{
            override fun onResponse(call: Call<Double>, response: Response<Double>) {
                if(response.isSuccessful){
                    val valor = response.body() ?: 0
                    binding.pbProgresso.progress = valor.toInt()
                }
            }

            override fun onFailure(call: Call<Double>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun verTrilha(view: View){
        val intent = Intent(baseContext, TrilhaCurso::class.java)
        startActivity(intent)
    }


    fun iniciarCurso(view: View){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        val id = prefs?.getInt("id", 0)
        val newUsuarioCurso = UsuarioCurso(
            idUsuarioCurso = null,
            fkCurso = cursoClicado!!,
            fkUsuario = id!!,
            finalizado = 0,
            date = null,
            progresso = 0.0
        )
        retrofitUsuarioCurso.postRecentCurso(newUsuarioCurso).enqueue(object: Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    val editor = getSharedPreferences(
                        "USER",
                        Context.MODE_PRIVATE
                    ).edit()
                    editor.putInt("indiceVideo", 1)
                    editor.apply()
                    val intent = Intent(baseContext, VideoCurso::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Algo deu errado :(", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}