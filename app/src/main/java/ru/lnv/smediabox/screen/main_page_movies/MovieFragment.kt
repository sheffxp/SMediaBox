package ru.lnv.smediabox.screen.main_page_movies

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import ru.lnv.smediabox.R
import ru.lnv.smediabox.databinding.FragmentMovieBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY

class MovieFragment : Fragment() {
    private var _mbinding:FragmentMovieBinding? = null
    private val mBinding get() = _mbinding!!
    private lateinit var mViewModel: MovieViewModel


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
    }

    private fun initialization() {
        mViewModel  = ViewModelProvider(this).get(MovieViewModel::class.java)

        initAdapters()
        setClickListeners()
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

        mBinding.btnMovieGenres.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnMovieGenres", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnMovieTrailers.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnMovieTrailers", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnTrendingPeoples.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnTrendingPeoples", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY.window.navigationBarColor = ContextCompat.getColor(APP_ACTIVITY, R.color.mine_shaft)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            APP_ACTIVITY.window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }


     }


    private fun initAdapters() {
        lifecycleScope.launchWhenCreated {

        }
    }
}