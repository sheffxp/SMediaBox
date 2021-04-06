package ru.lnv.smediabox.screen.main_page_movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import ru.lnv.smediabox.data.repositories.MovieRepository
import ru.lnv.smediabox.domain.enums.MovieCollectionType
import ru.lnv.smediabox.screen.main_page_movies.datasources.MovieCollectionsPagingDataSource

class MovieViewModel(private val movieRepository: MovieRepository
) : ViewModel() {




    /**
     * Upcoming movies
     */

    var popularDataSource: MovieCollectionsPagingDataSource? = null

    var popularMoviesFlow = Pager(PagingConfig(pageSize = 20)) {
        MovieCollectionsPagingDataSource(movieRepository, MovieCollectionType.POPULAR).also {
            popularDataSource = it
        }
    }.flow.cachedIn(viewModelScope)


}