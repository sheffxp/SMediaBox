package ru.lnv.smediabox.data.repositories

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.lnv.smediabox.data.api.TmdbApi
import ru.lnv.smediabox.models.genre.Genre
import ru.lnv.smediabox.models.genre.GenreResponse
import ru.lnv.smediabox.models.movie.GetMoviesResponse
import ru.lnv.smediabox.models.movie.Movie

object MoviesRepository {
    private val TMDB_API: TmdbApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        TMDB_API = retrofit.create(TmdbApi::class.java)
    }

    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        TMDB_API.getPopularMovies(page = page)
            .enqueue(object : Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            //Log.d("Repository", "Movies: ${responseBody.movies}")
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                            //Log.d("Repository", "Failed to get response")
                        }
                    }
                }
                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }


    fun getTopRatedMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ){
        TMDB_API.getTopRatedMovies(page = page)
            .enqueue(object : Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }


    fun getMovieGenres(
        onSuccess: (genres: List<Genre>) -> Unit,
        onError: () -> Unit
    )
    {
        TMDB_API.getMovieGenres()
            .enqueue(object : Callback<GenreResponse> {
                override fun onResponse(
                    call: Call<GenreResponse>,
                    response: Response<GenreResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.genres)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

}