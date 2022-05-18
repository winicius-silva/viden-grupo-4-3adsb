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
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import com.example.viden.services.UsuarioCursoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeusCursosCurso : AppCompatActivity() {

    private var cursoClicado: Int = 0
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
        cursoClicado = intent.getStringExtra("cursoClicado")?.toInt() ?: 0
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
        retrofitCurso.getOneCurso(cursoClicado).enqueue(object: Callback<Curso>{
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

}