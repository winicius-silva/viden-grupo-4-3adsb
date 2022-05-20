package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        binding = ActivityVideoCursoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gerarVideo()
    }

    fun gerarVideo(){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        val indiceVideo = prefs?.getInt("indiceVideo", 0)
        retrofitVideo.getIndiceVideoByCurso(indiceVideo!!, cursoClicado!!).enqueue(
            object: Callback<Video>{
                override fun onResponse(call: Call<Video>, response: Response<Video>) {
                    if(response.isSuccessful){
                        binding.tvTituloVideo.text = response.body()!!.titulo
                        binding.tvDescricaoVideo.text = response.body()!!.descricaoVideo
                    } else {
                        Toast.makeText(baseContext, "Erro ao carregar", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Video>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    fun passarVideo(view: View){
        val prefs = getSharedPreferences("USER", Context.MODE_PRIVATE)
        val cursoClicado = prefs?.getInt("cursoClicado", 0)
        val indiceVideo = prefs?.getInt("indiceVideo", 0)
        val teste = indiceVideo!! + 1
        retrofitVideo.getIndiceVideoByCurso(teste, cursoClicado!!).enqueue(
            object: Callback<Video>{
                override fun onResponse(call: Call<Video>, response: Response<Video>) {
                    if(response.isSuccessful){
                        if(response.body()?.idVideoCurso != null){
                            val intent = Intent(baseContext, VideoCurso::class.java)
                            val editor = getSharedPreferences(
                                "USER",
                                Context.MODE_PRIVATE
                            ).edit()
                            editor.putInt("indiceVideo", response.body()!!.indice)
                            editor.apply()
                            startActivity(intent)
                        } else {
                            val botaoFinalizar: LinearLayout = findViewById(R.id.ll_botao_finalizar)
                            botaoFinalizar.isVisible = true
                            Toast.makeText(baseContext, "Parabens, esse é o ultimo video do seu curso!",
                                Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(baseContext, "Erro ao chamar este video",
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
    }

    fun irTrilhaCurso(view: View){
        startActivity(Intent(baseContext, TrilhaCurso::class.java))
    }

    fun finalizarCurso(view: View){
        Toast.makeText(baseContext, "Obrigado por assistir esse curso", Toast.LENGTH_LONG).show()
        startActivity(Intent(baseContext, MeusCursos::class.java))
    }
}