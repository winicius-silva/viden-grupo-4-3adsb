package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viden.adapters.CursoLinearAdapter
import com.example.viden.databinding.ActivityMeusCursosBinding
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
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMeusCursosBinding
    val listCurso = mutableListOf<Curso>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        supportFragmentManager.executePendingTransactions()
        binding = ActivityMeusCursosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startUI()
        cursosRecentes()
    }

    private fun startUI() {
        recyclerView = findViewById(R.id.recycler_view)
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
                    if(!responseUsuarioCurso.body().isNullOrEmpty()){
                        responseUsuarioCurso.body()!!.forEach{ usuarioCurso ->
                            if(usuarioCurso == null){
                                Toast.makeText(baseContext, "Não temos cursos para voce!", Toast.LENGTH_LONG).show()
                            } else {
                                retrofitCurso.getOneCurso(usuarioCurso.fkCurso).enqueue(object : Callback<Curso>{
                                    override fun onResponse(call: Call<Curso>, responseCurso: Response<Curso>) {
                                        if(responseCurso.isSuccessful){
                                            if(responseCurso.body() != null){
                                                listCurso.add(responseCurso.body()!!)
                                                setDataToRecyclerView(listCurso)
                                            }
                                        } else {
                                            Toast.makeText(baseContext, responseCurso.message(), Toast.LENGTH_LONG).show()
                                        }
                                    }

                                    override fun onFailure(call: Call<Curso>, t: Throwable) {
                                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                                    }
                                })
                            }
                            }
                    } else {
                        Toast.makeText(baseContext, "Não temos cursos para voce!", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<UsuarioCurso>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setDataToRecyclerView(cursoList: List<Curso>) {
        recyclerView.isNestedScrollingEnabled = true
        recyclerView.adapter = CursoLinearAdapter(cursoList) { curso ->
            val intent = Intent(baseContext, MeusCursosCurso::class.java)
            intent.putExtra("cursoClicado", curso.idCurso.toString())
            startActivity(intent)
        }
    }
}