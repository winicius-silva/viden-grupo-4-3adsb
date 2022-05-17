package com.example.viden.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viden.R
import com.example.viden.models.Curso

class CursoAdapter (
    val cursos: List<Curso>,
    val onClick: (Curso) -> Unit
) : RecyclerView.Adapter<CursoAdapter.CursosViewHolder>() {

    class CursosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvCursoImage: ImageView = view.findViewById(R.id.tvCursoImage)
        var tvCursoTitle: TextView = view.findViewById(R.id.tvCursoTitle)
        val tvCursoDescription: TextView = view.findViewById(R.id.tvCursoDescription)
    }

    override fun getItemCount() = cursos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.curso_adapter, parent, false)
        view.findViewById<LinearLayout>(R.id.ll_curso).setOnClickListener {
            irMeusCursosCurso(view)
        }
        return CursosViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val curso = cursos[position]
        val cursoImage = curso.cursoImg
        holder.tvCursoTitle.text = curso.nomeCurso
        holder.tvCursoDescription.text = curso.descricao

        Glide
            .with(holder.itemView)
            .load(cursoImage)
            .into(holder.tvCursoImage)
        /*
        * Aqui modificaremos as propriedades do nosso CursosViewHolder
        * */
        holder.itemView.setOnClickListener {
            onClick(curso)
        }
    }

    fun irMeusCursosCurso(view: View){

    }

}


