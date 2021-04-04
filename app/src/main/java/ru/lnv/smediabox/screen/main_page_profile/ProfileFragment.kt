package ru.lnv.smediabox.screen.main_page_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ru.lnv.smediabox.R
import ru.lnv.smediabox.databinding.FragmentProfileBinding
import ru.lnv.smediabox.databinding.FragmentTvsBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.screen.dialogs.LogoutDialog
import ru.lnv.smediabox.screen.main_page_tvs.TVsMovieViewModel


class ProfileFragment : Fragment() {
    private var _mbinding: FragmentProfileBinding? = null
    private val mBinding get() = _mbinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mbinding = FragmentProfileBinding.inflate(layoutInflater, container, false)
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
      //  mViewModel  = ViewModelProvider(this).get(TVsMovieViewModel::class.java)

        initAdapters()
        setClickListeners()
    }

    private fun initAdapters() {
        lifecycleScope.launchWhenCreated {

        }
    }

    private fun setClickListeners() {

        mBinding.btnSettings.setOnClickListener {
            APP_ACTIVITY.mBinding.navView.isVisible = false
            APP_ACTIVITY.mVavController.navigate(R.id.action_profileFragment_to_settingsFragment)
        }
        mBinding.btnSettingsWithText.setOnClickListener {
            APP_ACTIVITY.mBinding.navView.isVisible = false
            APP_ACTIVITY.mVavController.navigate(R.id.action_profileFragment_to_settingsFragment)
        }

        mBinding.btnAuth.setOnClickListener {
            showLogoutDialog()
        }

    }

    private fun showLogoutDialog() {
        val logoutDialog = LogoutDialog()
        logoutDialog.show(childFragmentManager, "logout_dialog")
    }

    override fun onResume() {
        APP_ACTIVITY.mBinding.navView.isVisible = true
        super.onResume()
    }
}