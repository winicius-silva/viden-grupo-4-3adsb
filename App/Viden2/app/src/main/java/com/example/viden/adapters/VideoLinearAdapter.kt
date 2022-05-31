package com.example.viden.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.viden.R
import com.example.viden.models.Video

class VideoLinearAdapter(
    val videos: List<Video>,
    val onClick: (Video) -> Unit
) : RecyclerView.Adapter<VideoLinearAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(video: Video, onVideoClickListener: (Video) -> Unit){
            val imagem = when(video.idVideoCurso){
                18 -> R.drawable.aula_1_java
                19 -> R.drawable.aula_2_java
                20 -> R.drawable.aula_3_java
                21 -> R.drawable.aula_1_react
                22 -> R.drawable.aula_2_react
                23 -> R.drawable.aula_3_react
                24 -> R.drawable.aula_1_go
                25 -> R.drawable.aula_2_go
                26 -> R.drawable.aula_3_go
                27 -> R.drawable.aula_1_ux
                28 -> R.drawable.aula_2_ux
                29 -> R.drawable.aula_3_ux
                else -> R.drawable.ic_launcher_background
            }
            Glide.with(itemView.context)
                .load(imagem)
                .apply(RequestOptions())
                .into(itemView.findViewById(R.id.iv_video_image))

            itemView.findViewById<TextView>(R.id.tv_title_video).text = video.titulo
            itemView.findViewById<TextView>(R.id.tv_descricao).text = video.descricaoVideo

            itemView.setOnClickListener {
                onVideoClickListener(video)
            }
        }
    }

    override fun getItemCount() = videos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videos[position]
        holder.bind(video, onClick)
    }
}