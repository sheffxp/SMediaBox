package ru.lnv.smediabox.data.api

import retrofit2.http.*
import ru.lnv.smediabox.domain.tmdbModels.movie.MovieResponse

interface TmdbApiService {
    // Movies

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): MovieResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?
    ): MovieResponse

    // TVs

//    @GET("tv/popular")
//    suspend fun getPopularTVs(
//        @Query("language") language: String?,
//        @Query("page") page: Int?
//    ): TVResponse
//
//    @GET("tv/top_rated")
//    suspend fun getTopRatedTVs(
//        @Query("language") language: String?,
//        @Query("page") page: Int?
//    ): TVResponse
//
//    @GET("tv/airing_today")
//    suspend fun getAiringTodayTVs(
//        @Query("language") language: String?,
//        @Query("page") page: Int?
//    ): TVResponse
//
//    @GET("tv/on_the_air")
//    suspend fun getOnTheAirTVs(
//        @Query("language") language: String?,
//        @Query("page") page: Int?
//    ): TVResponse

    // Persons

//    @GET("person/popular")
//    suspend fun getPopularPeoples(
//        @Query("language") language: String?,
//        @Query("page") page: Int?
//    ): PersonResponse

    // Season & Episode

    // Genres

//    @GET("genre/movie/list")
//    suspend fun getMovieGenres(
//        @Query("language") language: String?
//    ): GenreResponse
//
//    @GET("genre/tv/list")
//    suspend fun getTVGenres(
//        @Query("language") language: String?
//    ): GenreResponse

    // Account

//    @GET("account")
//    suspend fun getAccountDetails(
//        @Query("session_id") sessionId: String
//    ): AccountDetails

//    @GET("account/{session_id}/favorite/movies")
//    suspend fun getFavoriteMovies(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): MovieResponse
//
//    @GET("account/{session_id}/favorite/tv")
//    suspend fun getFavoriteTVs(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): TVResponse
//
//    @POST("account/{session_id}/favorite")
//    suspend fun markIsFavorite(
//        @Body requestMarkAsFavorite: RequestMarkAsFavorite,
//        @Query("session_id") sessionId: String
//    ): ApiResponse
//
//    @GET("account/{session_id}/rated/movies")
//    suspend fun getRatedMovies(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): MovieResponse
//
//    @GET("account/{session_id}/rated/tv")
//    suspend fun getRatedTVs(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): TVResponse
//
//    @GET("account/{session_id}/rated/tv/episodes")
//    suspend fun getRatedEpisodes(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): TVEpisodeResponse
//
//    @GET("account/{session_id}/watchlist/movies")
//    suspend fun getWatchlistMovies(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): MovieResponse
//
//    @GET("account/{session_id}/watchlist/tv")
//    suspend fun getWatchlistTVs(
//        @Query("language") language: String?,
//        @Query("session_id") sessionId: String,
//        @Query("sort_by") sortBy: String?,
//        @Query("page") page: Int?
//    ): TVResponse
//
//    @POST("account/{session_id}/watchlist")
//    suspend fun addToWatchlist(
//        @Body requestAddToWatchlist: RequestAddToWatchlist,
//        @Query("session_id") sessionId: String
//    ): ApiResponse
//
//    // trending
//
//    @GET("trending/{media_type}/{time_window}")
//    suspend fun getTrendingMovies(
//        @Path("media_type") mediaType: String,
//        @Path("time_window") timeWindow: String,
//        @Query("page") page: Int?,
//        @Query("language") language: String?
//    ): MovieResponse
//
//    @GET("trending/{media_type}/{time_window}")
//    suspend fun getTrendingTVs(
//        @Path("media_type") mediaType: String,
//        @Path("time_window") timeWindow: String,
//        @Query("page") page: Int?,
//        @Query("language") language: String?
//    ): TVResponse
//
//    @GET("trending/{media_type}/{time_window}")
//    suspend fun getTrendingPeoples(
//        @Path("media_type") mediaType: String,
//        @Path("time_window") timeWindow: String,
//        @Query("language") language: String?
//    ): PersonResponse
}