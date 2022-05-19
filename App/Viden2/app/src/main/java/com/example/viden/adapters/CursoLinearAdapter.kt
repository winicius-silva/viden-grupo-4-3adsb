package com.example.viden.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.viden.R
import com.example.viden.models.Curso

class CursoLinearAdapter (
    val cursos: List<Curso>,
    val onClick: (Curso) -> Unit
) : RecyclerView.Adapter<CursoLinearAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(curso: Curso, onCursoClickListener: (Curso) -> Unit){
            Glide.with(itemView.context)
                .load(R.drawable.python_curso_img)
                .apply(RequestOptions())
                .into(itemView.findViewById(R.id.tv_curso_image))

            itemView.findViewById<TextView>(R.id.tv_curso_title).text = curso.nomeCurso
            itemView.findViewById<TextView>(R.id.tv_curso_description).text = curso.descricao

//            when(curso.categoria) {
//                "macho" -> itemView.findViewById<ImageView>(R.id.iv_gender).setImageResource(R.drawable.ic_card_male)
//                "femea" -> itemView.findViewById<ImageView>(R.id.iv_gender).setImageResource(R.drawable.ic_card_female)
//            }

            itemView.setOnClickListener {
                onCursoClickListener(curso)
            }
        }
    }

    override fun getItemCount() = cursos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.curso_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = cursos[position]
        holder.bind(animal, onClick)
    }

}


