package ru.lnv.smediabox.screen.main_page_movies.datasources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.lnv.smediabox.data.repositories.MovieRepository
import ru.lnv.smediabox.domain.enums.MovieCollectionType
import ru.lnv.smediabox.domain.tmdbModels.movie.Movie
import ru.lnv.smediabox.domain.tmdbModels.movie.MovieResponse
import ru.lnv.smediabox.models.results.ResultWrapper

class MovieCollectionsPagingDataSource (
    private val repository: MovieRepository,
    private val collectionType: MovieCollectionType
    ) : PagingSource<Int, Movie>() {

        private var totalPages: Int? = null

        override suspend fun load(
            params: PagingSource.LoadParams<Int>
        ): PagingSource.LoadResult<Int, Movie> {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1

            if (totalPages != null && nextPageNumber > totalPages!!) {
                return PagingSource.LoadResult.Error(Exception("Max page. nextPage: $nextPageNumber, maxPage: $totalPages"))
            }

            return when (val response = getMoviesCollectionsByType(nextPageNumber)) {
                is ResultWrapper.GenericError -> {
                    //Logger.e("Generic Error")

                    PagingSource.LoadResult.Error(
                        Exception(
                            "Generic Error  ${response.error?.statusMessage} ${response.error?.statusCode}"
                        )
                    )
                }

                is ResultWrapper.NetworkError -> {
                    //Logger.e("Network Error")
                    PagingSource.LoadResult.Error(Exception("Network Error}"))
                }

                is ResultWrapper.Success -> {
                    totalPages = response.value.totalPages

                    PagingSource.LoadResult.Page(
                        data = response.value.results,
                        prevKey = null, // Only paging forward.
                        nextKey = nextPageNumber + 1
                    )
                }
            }
        }

        private suspend fun getMoviesCollectionsByType(nextPage: Int): ResultWrapper<MovieResponse> {
            return when (collectionType) {
                MovieCollectionType.POPULAR -> {
                    repository.getPopularMovies("ru", nextPage, null)
                }

//                MovieCollectionType.TOP_RATED -> {
//                    repository.getTopRatedMovies("ru", nextPage, null)
//                }
//
//                MovieCollectionType.UPCOMING -> {
//                    repository.getUpcomingMovies("ru", nextPage, null)
//                }
//
//                MovieCollectionType.NOW_PLAYING -> {
//                    repository.getNowPlayingMovies("ru", nextPage, null)
//                }
            }
        }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return 10
        }


}
