package ru.lnv.smediabox.screen.settings

import android.app.usage.StorageStatsManager
import android.content.Context
import android.content.pm.PackageStats
import android.os.Build
import android.os.Bundle
import android.os.Process
import android.os.storage.StorageManager
import android.text.format.Formatter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import ru.lnv.smediabox.R
import ru.lnv.smediabox.databinding.FragmentMovieBinding
import ru.lnv.smediabox.databinding.FragmentSettingsBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.BaseSlidingFragment
import ru.lnv.smediabox.extensions.FRAGMENT
import ru.lnv.smediabox.extensions.calculateCache
import ru.lnv.smediabox.screen.dialogs.ClearCacheDialog
import ru.lnv.smediabox.screen.dialogs.LogoutDialog


class SettingsFragment : Fragment() {
    private var _mbinding: FragmentSettingsBinding? = null
    private val mBinding get() = _mbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mbinding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _mbinding = null
    }


    override fun onStart() {
        super.onStart()
        FRAGMENT = mBinding.settingsFragment
        APP_ACTIVITY.canSlideDown = true
        setClickListeners()
    }

    private fun setClickListeners() {
        mBinding.btnClearCache.setOnClickListener {
            showClearCacheDialog()
        }
    }

    private fun showClearCacheDialog() {
        val ClearCacheDialog = ClearCacheDialog()
        ClearCacheDialog.show(childFragmentManager, "ClearCacheDialog")
    }

    override fun onResume() {
        super.onResume()
        mBinding.settingsCacheSize.text = Formatter.formatShortFileSize(APP_ACTIVITY, calculateCache())
    }

}