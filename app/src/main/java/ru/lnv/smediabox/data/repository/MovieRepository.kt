package ru.lnv.smediabox.data.repositories

import ru.lnv.smediabox.data.api.TmdbApiService
import ru.lnv.smediabox.domain.models.CollectionResponse
import ru.lnv.smediabox.domain.models.movie.MovieDetails

class MovieRepository(private val api: TmdbApiService) : BaseRepository() {
    suspend fun getMovieById(
        movieId: Int,
        language: String?,
        appendToResponse: String?,
        imageLanguages: String?
    ): MovieDetails? {
        return safeApiCall(
            call = {
                api.getMovieById(movieId, language, appendToResponse, imageLanguages).await()
            },
            errorMessage = "Ошибка при получении информации о фильме"
        )
    }

    suspend fun getPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): MutableList<CollectionResponse.CollectionItem>? {
        val movieResponse = safeApiCall(
            call = { api.getPopularMovies(language, page, region).await() },
            errorMessage = "Ошибка при получения популярных фильмов"
        )

        return movieResponse?.results?.toMutableList()
    }



}