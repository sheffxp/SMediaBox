package ru.lnv.smediabox.screen.main_page_tvs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ru.lnv.smediabox.databinding.FragmentTvsBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY

class TVsFragment : Fragment() {
    private var _mbinding: FragmentTvsBinding? = null
    private val mBinding get() = _mbinding!!
    private lateinit var mViewModel: TVsMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mbinding = FragmentTvsBinding.inflate(layoutInflater, container, false)
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
        mViewModel  = ViewModelProvider(this).get(TVsMovieViewModel::class.java)

        initAdapters()
        setClickListeners()
    }

    private fun initAdapters() {
        lifecycleScope.launchWhenCreated {

        }
    }

    private fun setClickListeners() {
        mBinding.btnSearch.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnSearch", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnPopularTvs.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnPopularTvs", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnAirTodayTvs.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnAirTodayTvs", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnTrendingTvs.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnTrendingTvs", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnOnTheAirTvs.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnOnTheAirTvs", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnCompanies.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnCompanies", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnTvGenres.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnTvGenres", Toast.LENGTH_SHORT).show()
        }

        mBinding.btnTvTrailers.setOnClickListener {
            Toast.makeText(APP_ACTIVITY, "btnTvTrailers", Toast.LENGTH_SHORT).show()
        }
    }

}