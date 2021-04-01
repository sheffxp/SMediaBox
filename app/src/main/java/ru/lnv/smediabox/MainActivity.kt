package ru.lnv.smediabox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.lnv.smediabox.databinding.ActivityMainBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.replaceFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        replaceFragment(LoginFragment(), false)
    }


}