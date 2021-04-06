package ru.lnv.smediabox.screen.main_page_movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.lnv.smediabox.domain.tmdbModels.movie.Movie
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.lnv.smediabox.databinding.ItemBigImageWithCornersBinding
import ru.lnv.smediabox.extensions.UrlConstants
import ru.lnv.smediabox.extensions.displayImageWithCenterCrop
import ru.lnv.smediabox.extensions.getMovieDiffUtils
import ru.lnv.smediabox.extensions.setSafeOnClickListener

class MovieCardAdapter (private val clickAction: (id: Int) -> Unit) : PagingDataAdapter<Movie, MovieCardAdapter.MovieCardViewHolder>(
    getMovieDiffUtils()
) {

    class MovieCardViewHolder(val viewBinding: ItemBigImageWithCornersBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindTo(movie: Movie) {
            viewBinding.placeholderText.text = movie.title

            viewBinding.sliderImage.displayImageWithCenterCrop(
                UrlConstants.TMDB_BACKDROP_SIZE_1280 + movie.backdropPath
            )
        }
    }

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) {
        getItem(position)?.let { movie ->
            holder.bindTo(movie)

            holder.viewBinding.sliderLayout.setSafeOnClickListener {
                clickAction(movie.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBigImageWithCornersBinding.inflate(layoutInflater, parent, false)

        return MovieCardViewHolder(binding)
    }

}