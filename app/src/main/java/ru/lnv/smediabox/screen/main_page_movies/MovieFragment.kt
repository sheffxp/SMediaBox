package ru.lnv.smediabox.screen.main_page_movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.isEmpty
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ru.lnv.smediabox.data.repositories.MoviesRepository
import ru.lnv.smediabox.databinding.FragmentMovieBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.models.genre.Genre
import ru.lnv.smediabox.models.movie.Movie
import ru.lnv.smediabox.objects.GenresStorageObject
import ru.lnv.smediabox.screen.main_page_movies.adapters.MoviesPopularAdapter
import ru.lnv.smediabox.screen.main_page_movies.adapters.MoviesTopRatedAdapter

class MovieFragment : Fragment() {
    private var _mbinding:FragmentMovieBinding? = null
    private val mBinding get() = _mbinding!!
    private lateinit var mViewModel: MovieViewModel

    //private lateinit var popularMovies: RecyclerView

    private lateinit var popularMoviesPopularAdapter: MoviesPopularAdapter
    private lateinit var topratedMoviesTopRatedAdapter: MoviesTopRatedAdapter

    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager

    private var popularMoviesPage = 1

    private var topRatedMoviesPage = 1

    /**
     * Adapters
     */

    /**
     * Default methods
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mbinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mbinding = null
    }

    override fun onStart() {
        super.onStart()
        initialization()

//        popularMovies = APP_ACTIVITY.findViewById(R.id.rv_now_playing_movies)
//        popularMoviesLayoutMgr = LinearLayoutManager(
//            APP_ACTIVITY,
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )

        //popularMovies.layoutManager = popularMoviesLayoutMgr


        //popularMovies.adapter = popularMoviesPopularAdapter




    }



    private fun attachPopularMoviesOnScrollListener() {


//        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                val totalItemCount = popularMoviesLayoutMgr.itemCount
//                val visibleItemCount = popularMoviesLayoutMgr.childCount
//                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()
//                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
//                    popularMovies.removeOnScrollListener(this)
                    popularMoviesPage++
                    getPopularMovies()
//                }
//            }
//        })
    }

    private fun attachTopratedMoviesOnScrollListener() {
        topRatedMoviesPage++
        getTopratedMovies()
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMoviesPopularAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun onTopratedMoviesFetched(movies: List<Movie>) {
        topratedMoviesTopRatedAdapter.appendMovies(movies)
        attachTopratedMoviesOnScrollListener()

    }

    private fun onError() {
        Toast.makeText(APP_ACTIVITY, "error movie popular", Toast.LENGTH_SHORT).show()
    }

    private fun initialization() {
        mViewModel  = ViewModelProvider(this).get(MovieViewModel::class.java)

        initAdapters()

        getPopularMovies()
        getTopratedMovies()

        getMovieGenres()
        //setMovieGenres()
        setClickListeners()
    }

    private fun initAdapters() {
        lifecycleScope.launchWhenCreated {
            popularMoviesPopularAdapter = MoviesPopularAdapter(mutableListOf())
            mBinding.vpPopularMovies.adapter = popularMoviesPopularAdapter
        }

        lifecycleScope.launchWhenCreated {
            topratedMoviesTopRatedAdapter = MoviesTopRatedAdapter(mutableListOf())
            mBinding.vpTrendMovies.adapter = topratedMoviesTopRatedAdapter
        }

    }

    private fun getPopularMovies(){
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun getTopratedMovies(){
        MoviesRepository.getTopRatedMovies(
            topRatedMoviesPage,
            ::onTopratedMoviesFetched,
            ::onError
        )
    }

    private  fun getMovieGenres(){
       MoviesRepository.getMovieGenres(
                ::setMovieGenres,
                ::onError
       )
    }





    private fun setMovieGenres(genres: List<Genre>) {
        if (GenresStorageObject.movieGenres.isEmpty()) {
            genres.map { genre ->
                GenresStorageObject.movieGenres.put(
                    genre.id,
                    genre.name
                )
            }
        }
    }




    private fun setClickListeners() {
        mBinding.btnSearch.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnSearch", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnPopularMovies.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnPopularMovies", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnUpcomingMovies.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnUpcomingMovies", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnNowPlayingMovies.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnNowPlayingMovies", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnTrendingMovies.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnTrendingMovies", Toast.LENGTH_SHORT).show()
        }


        mBinding.btnMovieTrailers.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnMovieTrailers", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnTrendingPeoples.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnTrendingPeoples", Toast.LENGTH_SHORT).show()
        }
    }

}