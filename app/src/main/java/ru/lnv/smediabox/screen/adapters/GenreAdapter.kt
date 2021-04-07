package ru.lnv.smediabox.screen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.lnv.smediabox.R
import ru.lnv.smediabox.models.genre.Genre

class GenreAdapter (private var genre: MutableList<Genre>) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view)
    }

    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val genreName: TextView = itemView.findViewById(R.id.genre_name)
        fun bind(genre: Genre) {
            genreName.text = genre.name
        }
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(genre[position])
    }

    override fun getItemCount(): Int = genre.size

}

