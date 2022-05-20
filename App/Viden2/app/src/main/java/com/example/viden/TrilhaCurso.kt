package com.example.viden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viden.adapters.CursoLinearAdapter
import com.example.viden.adapters.VideoLinearAdapter
import com.example.viden.fragment.Menu
import com.example.viden.models.Curso
import com.example.viden.models.Video
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import com.example.viden.services.VideoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrilhaCurso : AppCompatActivity() {

    private val retrofitVideo = Rest.getInstance().create(VideoService::class.java)
    private lateinit var cursoClicado: String
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trilha_curso)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        startUI()
        cursoClicado = intent.getStringExtra("cursoClicado").toString()
        gerarVideos()
    }

    private fun startUI() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    fun gerarVideos(){
        retrofitVideo.getVideosByCurso(cursoClicado.toInt()).enqueue(object: Callback<List<Video>> {
            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
                if(response.isSuccessful){
                    if(response.body() != null){
                        setDataToRecyclerView(response.body()!!)
                    } else {
                        Toast.makeText(baseContext, "Não encontramos videos para este curso",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    fun voltarParaCurso(view: View){
        startActivity(Intent(baseContext, MeusCursosCurso::class.java))
        intent.putExtra("cursoClicado", cursoClicado)
        startActivity(intent)
    }

    fun irConcluirCurso(view: View){
        startActivity(Intent(baseContext, ConcluirCurso::class.java))
    }

    private fun setDataToRecyclerView(videoList: List<Video>) {
        recyclerView.isNestedScrollingEnabled = true
        recyclerView.adapter = VideoLinearAdapter(videoList) { video ->
            val intent = Intent(baseContext, VideoCurso::class.java)
            intent.putExtra("videoClicado", video.idVideoCurso.toString())
            intent.putExtra("tituloVideo", video.titulo)
            intent.putExtra("descricaoVideo", video.descricaoVideo)
            intent.putExtra("linkVideo", video.link)
            intent.putExtra("indiceVideo", video.indice)
            intent.putExtra("cursoClicado", cursoClicado)
            startActivity(intent)
        }
    }
}