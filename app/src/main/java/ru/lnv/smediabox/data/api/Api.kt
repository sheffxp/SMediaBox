package ru.lnv.smediabox.data.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.lnv.smediabox.models.genre.GenreResponse
import ru.lnv.smediabox.models.movie.GetMoviesResponse

interface Api {
    //популярные
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "dd0aacb00ed40a691a9a41b5e3b7cdb3",
        @Query("page") page: Int,
        @Query("language") lng: String = "ru",
        @Query("region") region: String = "RU"
    ): Call<GetMoviesResponse>

    //в тренде
    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "dd0aacb00ed40a691a9a41b5e3b7cdb3",
        @Query("page") page: Int,
        @Query("language") lng: String = "ru",
        @Query("region") region: String = "RU"
    ): Call<GetMoviesResponse>

    //сейчас в кино
    //now_playing

    //ожидаемые
    //upcoming

    // Genres
    @GET("genre/movie/list")
    fun getMovieGenres(
        @Query("api_key") apiKey: String = "dd0aacb00ed40a691a9a41b5e3b7cdb3",
        @Query("language") lng: String = "ru"
    ): Call<GenreResponse>

    @GET("genre/tv/list")
    suspend fun getTVGenres(
        @Query("api_key") apiKey: String = "dd0aacb00ed40a691a9a41b5e3b7cdb3",
        @Query("language") lng: String = "ru"
    ): Call<GenreResponse>


}