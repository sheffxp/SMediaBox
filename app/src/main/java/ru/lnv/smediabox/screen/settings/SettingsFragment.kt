package ru.lnv.smediabox.screen.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.lnv.smediabox.R
import ru.lnv.smediabox.extensions.BaseSlidingFragment
import ru.lnv.smediabox.extensions.FRAGMENT


class SettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        FRAGMENT = inflater.inflate(R.layout.fragment_settings, container, false)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }



}