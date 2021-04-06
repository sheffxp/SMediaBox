package ru.lnv.smediabox.extensions

import androidx.recyclerview.widget.DiffUtil
import ru.lnv.smediabox.domain.tmdbModels.movie.Movie

fun getMovieDiffUtils() = object : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean = oldItem.id == newItem.id
}
//
//fun getPersonDiffUtils() = object : DiffUtil.ItemCallback<Person>() {
//    override fun areItemsTheSame(
//        oldItem: Person,
//        newItem: Person
//    ): Boolean = oldItem.id == newItem.id
//
//    override fun areContentsTheSame(
//        oldItem: Person,
//        newItem: Person
//    ): Boolean = oldItem.id == newItem.id
//}