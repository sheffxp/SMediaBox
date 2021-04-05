package ru.lnv.smediabox.data.api


import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.lnv.smediabox.domain.models.CollectionResponse
import ru.lnv.smediabox.domain.models.movie.MovieDetails


interface TmdbApiService {

    //Movies
    @GET("movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String?,
        @Query("append_to_response") appendToResponse: String?,
        @Query("include_image_language") imageLanguages: String?
    ): Deferred<Response<MovieDetails>>

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): Deferred<Response<CollectionResponse>>

}