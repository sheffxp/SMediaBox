package ru.lnv.smediabox.screen.main_page_movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.lnv.smediabox.R
import ru.lnv.smediabox.extensions.toDate
import ru.lnv.smediabox.models.movie.Movie
import ru.lnv.smediabox.objects.GenresStorageObject
import kotlin.math.roundToInt

class MoviesTopRatedAdapter(private var movies: MutableList<Movie>
) : RecyclerView.Adapter<MoviesTopRatedAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_trend_card_with_title, parent, false)
        return MovieViewHolder(view)
    }
    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    fun appendMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        notifyItemRangeInserted(
            this.movies.size,
            movies.size - 1
        )
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val trend_title: TextView = itemView.findViewById(R.id.m_trend_title)
        private val trend_year: TextView = itemView.findViewById(R.id.m_trend_year)
        private val trend_genres: TextView = itemView.findViewById(R.id.m_trend_genres)
        private val trend_rating: TextView = itemView.findViewById(R.id.m_trend_rating)
        fun bind(movie: Movie) {

            //m_trend_title
            trend_title.text = movie.title
            //m_trend_year
            trend_year.text = movie.releaseDate?.toDate()?.yearInt?.toString() ?: ""
            println("----------s-------------s-----------------s-------------------s----------------s-----------------s"+movie.genreIds)
            //m_trend_genres
            trend_genres.text =
                movie.genreIds.map { GenresStorageObject.movieGenres.get(it) }
                    .take(2)
                    .joinToString(" - ") { it ?: "" }
            //m_trend_rating
            trend_rating.text = "${(movie.rating * 10).roundToInt()}%"






        }
    }
}