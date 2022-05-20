package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.databinding.ActivityMeusCursosCursoBinding
import com.example.viden.fragment.Menu
import com.example.viden.models.Curso
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
    private val retrofitVideo= Rest.getInstance().create(VideoService::class.java)
    private lateinit var binding: ActivityMeusCursosCursoBinding
    private lateinit var cursoClicado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_cursos_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        cursoClicado = intent.getStringExtra("cursoClicado").toString()
        supportFragmentManager.executePendingTransactions()
        binding = ActivityMeusCursosCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gerarDadosCurso()
    }

    fun irMeusCursos(view: View){
        startActivity(Intent(baseContext, MeusCursos::class.java))
    }

    fun gerarDadosCurso(){
        val prefs = getSharedPreferences("ID", Context.MODE_PRIVATE)
        val id = prefs?.getInt("id", 0)
        retrofitCurso.getOneCurso(cursoClicado.toInt()).enqueue(object: Callback<Curso>{
            override fun onResponse(call: Call<Curso>, response: Response<Curso>) {
                if(response.isSuccessful){
                    binding.tvTitulo.text = response.body()?.nomeCurso.toString()
                    binding.tvDescricao.text = response.body()?.descricao.toString()
                    binding.tvPontos.text = response.body()?.qtdPontos.toString()
                }
            }

            override fun onFailure(call: Call<Curso>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

        retrofitUsuarioCurso.getProgressoByUsuarioByCurso(cursoClicado.toInt(), id!!).enqueue(object: Callback<Double>{
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
        intent.putExtra("cursoClicado", cursoClicado)
        startActivity(intent)
    }


    fun iniciarCurso(view: View){
        retrofitVideo.getIndiceVideoByCurso(1, cursoClicado.toInt()).enqueue(object: Callback<Video>{
            override fun onResponse(call: Call<Video>, response: Response<Video>) {
                if(response.isSuccessful){
                    if(response.body() != null){
                        val intent = Intent(baseContext, VideoCurso::class.java)
                        intent.putExtra("videoClicado", response.body()!!.idVideoCurso.toString())
                        intent.putExtra("tituloVideo", response.body()!!.titulo)
                        intent.putExtra("descricaoVideo", response.body()!!.descricaoVideo)
                        intent.putExtra("linkVideo", response.body()!!.link)
                        intent.putExtra("indiceVideo", response.body()!!.indice)
                        intent.putExtra("cursoClicado", cursoClicado)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Este curso nao tem video!", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<Video>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}