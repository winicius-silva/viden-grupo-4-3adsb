package com.example.viden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viden.adapters.CursoLinearAdapter
import com.example.viden.databinding.ActivityPesquisaBinding
import com.example.viden.fragment.Menu
import com.example.viden.models.Curso
import com.example.viden.rest.Rest
import com.example.viden.services.CursoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pesquisa : AppCompatActivity() {

    private val retrofitCurso = Rest.getInstance().create(CursoService::class.java)
    private lateinit var binding: ActivityPesquisaBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Menu>(R.id.containerFragmentMenu)
        }
        supportFragmentManager.executePendingTransactions()
        binding = ActivityPesquisaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startUI()
    }

    private fun startUI() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    fun pesquisar(view: View){
        var nomePesquisado = ""
        nomePesquisado = binding.etPesquisa.text.toString()
        retrofitCurso.getCursosSearch(nomePesquisado).enqueue(
            object: Callback<List<Curso>>{
                override fun onResponse(call: Call<List<Curso>>, response: Response<List<Curso>>) {
                    if(response.isSuccessful){
                        if(!response.body().isNullOrEmpty()){
                            response.body()?.forEach { result ->
                                if(result == null){
                                    Toast.makeText(baseContext, "Não encontramos cursos!", Toast.LENGTH_LONG).show()
                                } else {
                                    setDataToRecyclerView(response.body()!!)
                                }
                            }
                        } else {
                            Toast.makeText(baseContext, "Não encontramos cursos!", Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<List<Curso>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    private fun setDataToRecyclerView(cursoList: List<Curso>) {
        recyclerView.isNestedScrollingEnabled = true
        recyclerView.adapter = CursoLinearAdapter(cursoList) { curso ->
            val intent = Intent(baseContext, MeusCursosCurso::class.java)
            val editor = getSharedPreferences(
                "USER",
                Context.MODE_PRIVATE
            ).edit()
            editor.putInt("cursoClicado", curso.idCurso)
            editor.apply()
            startActivity(intent)
        }
    }
}