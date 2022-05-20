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
            Glide.with(itemView.context)
                .load(R.drawable.img_youtube)
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