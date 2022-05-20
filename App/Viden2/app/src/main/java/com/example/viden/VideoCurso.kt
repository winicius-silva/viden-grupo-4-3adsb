package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.viden.databinding.ActivityMeusCursosCursoBinding
import com.example.viden.databinding.ActivityVideoCursoBinding
import com.example.viden.fragment.Menu
import com.example.viden.models.Video
import com.example.viden.rest.Rest
import com.example.viden.services.VideoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideoCurso : AppCompatActivity() {

    private val retrofitVideo= Rest.getInstance().create(VideoService::class.java)
    private lateinit var binding: ActivityVideoCursoBinding
    private lateinit var videoClicado: String
    private lateinit var tituloVideo: String
    private lateinit var descricaoVideo: String
    private lateinit var linkVideo: String
    private lateinit var indiceVideo: String
    private lateinit var cursoClicado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        binding = ActivityVideoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        videoClicado = intent.getStringExtra("videoClicado").toString()
        tituloVideo = intent.getStringExtra("tituloVideo").toString()
        descricaoVideo = intent.getStringExtra("descricaoVideo").toString()
        linkVideo = intent.getStringExtra("linkVideo").toString()
        indiceVideo = intent.getStringExtra("indiceVideo").toString()
        cursoClicado = intent.getStringExtra("cursoClicado").toString()
        gerarVideo()
    }

    fun gerarVideo(){
        binding.tvTituloVideo.text = tituloVideo
        binding.tvDescricaoVideo.text = descricaoVideo
    }

    fun passarVideo(view: View){
        retrofitVideo.getIndiceVideoByCurso(indiceVideo.toInt(), cursoClicado.toInt()).enqueue(
            object: Callback<Video>{
                override fun onResponse(call: Call<Video>, response: Response<Video>) {
                    if(response.isSuccessful){
                        val intent = Intent(baseContext, VideoCurso::class.java)
                        intent.putExtra("videoClicado", response.body()!!.idVideoCurso.toString())
                        intent.putExtra("tituloVideo", response.body()!!.titulo)
                        intent.putExtra("descricaoVideo", response.body()!!.descricaoVideo)
                        intent.putExtra("linkVideo", response.body()!!.link)
                        intent.putExtra("indiceVideo", response.body()!!.indice)
                        intent.putExtra("cursoClicado", cursoClicado)
                        startActivity(intent)
                    } else {
                        val botaoFinalizar: Button = findViewById(R.id.bt_finalizar)
                        botaoFinalizar.isVisible = true
                        Toast.makeText(baseContext, "Parabens, esse é o ultimo video do seu curso!",
                            Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Video>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

            }
        )
    }

    fun irMeusCursosCurso(view: View){
        startActivity(Intent(baseContext, MeusCursosCurso::class.java))
        intent.putExtra("cursoClicado", cursoClicado)
        startActivity(intent)
    }

    fun irTrilhaCurso(view: View){
        startActivity(Intent(baseContext, TrilhaCurso::class.java))
        intent.putExtra("cursoClicado", cursoClicado)
        startActivity(intent)
    }

    fun finalizarCurso(view: View){
        Toast.makeText(baseContext, "Obrigado por assistir esse curso", Toast.LENGTH_LONG).show()
        startActivity(Intent(baseContext, MeusCursos::class.java))
        startActivity(intent)
    }
}