package ru.lnv.smediabox.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.lnv.smediabox.data.api.TmdbApiService
import ru.lnv.smediabox.domain.tmdbModels.movie.MovieResponse
import ru.lnv.smediabox.models.results.ResultWrapper

class MovieRepository(private val api: TmdbApiService) : BaseRepository() {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend fun getPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): ResultWrapper<MovieResponse> {
        return safeApiCall(dispatcher) { api.getPopularMovies(language, page, region) }
    }

//    suspend fun getTopRatedMovies(
//        language: String?,
//        page: Int?,
//        region: String?
//    ): ResultWrapper<MovieResponse> {
//        return safeApiCall(dispatcher) { api.getTopRatedMovies(language, page, region) }
//    }
//
//    suspend fun getMovieGenres(language: String?): ResultWrapper<GenreResponse> {
//        return safeApiCall(dispatcher) { api.getMovieGenres(language) }
//    }
//
//    suspend fun getUpcomingMovies(
//        language: String?,
//        page: Int?,
//        region: String?
//    ): ResultWrapper<MovieResponse> {
//        return safeApiCall(dispatcher) {
//            api.getUpcomingMovies(language, page, region)
//        }
//    }
//
//    suspend fun getNowPlayingMovies(
//        language: String?,
//        page: Int?,
//        region: String?
//    ): ResultWrapper<MovieResponse> {
//        return safeApiCall(dispatcher) {
//            api.getNowPlayingMovies(language, page, region)
//        }
//    }
}