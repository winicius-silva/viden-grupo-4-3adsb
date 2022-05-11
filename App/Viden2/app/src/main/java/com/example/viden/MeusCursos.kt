package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viden.adapters.CursoAdapter
import com.example.viden.fragment.Menu
import com.example.viden.models.Curso
import com.example.viden.models.UsuarioCurso
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import com.example.viden.services.UsuarioCursoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeusCursos : AppCompatActivity() {

    private val retrofitUsuarioCurso = Rest.getInstance().create(UsuarioCursoService::class.java)
    private val retrofitCurso = Rest.getInstance().create(CursoService::class.java)
    private lateinit var etId: EditText
    private lateinit var llContainer: LinearLayout
    private lateinit var recyclerView: RecyclerView
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_cursos)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        startUI()
    }

    private fun startUI() {
//        llContainer = binding.llFilmesContainer
//        etId = binding.etId
        recyclerView = findViewById(R.id.cursoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    fun cursosRecentes(){
        val prefs = getSharedPreferences("ID", Context.MODE_PRIVATE)
        val id = prefs?.getInt("id", 0)
        retrofitUsuarioCurso.getMyCurso(id!!).enqueue(object : Callback<List<UsuarioCurso>> {
            override fun onResponse(call: Call<List<UsuarioCurso>>, responseUsuarioCurso: Response<List<UsuarioCurso>>) {
                if(responseUsuarioCurso.isSuccessful){
                    responseUsuarioCurso.body()?.forEach{ usuarioCurso ->
                        retrofitCurso.getOneCurso(usuarioCurso.fkCurso)
                            .enqueue(object : Callback<Curso>{
                                override fun onResponse(call: Call<Curso>, responseCurso: Response<Curso>) {
                                    if(responseCurso.isSuccessful){
                                        if(responseCurso.body() != null){
                                            llContainer.removeAllViews()
                                            val tvCurso = TextView(baseContext)
                                            tvCurso.text = responseCurso.body()?.nomeCurso
                                            llContainer.addView(tvCurso)
                                        } else {
                                            Toast.makeText(baseContext, responseCurso.message(), Toast.LENGTH_LONG).show()
                                        }
                                    }
                                }

                                override fun onFailure(call: Call<Curso>, t: Throwable) {
                                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                                }
                            })
                    }
                }
            }

            override fun onFailure(call: Call<List<UsuarioCurso>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
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

    fun irMinhaConta(view: View){
        startActivity(Intent(baseContext, MinhaConta::class.java))
    }

    fun irMeusCursosCurso(view: View){
        startActivity(Intent(baseContext, MeusCursosCurso::class.java))
    }
}