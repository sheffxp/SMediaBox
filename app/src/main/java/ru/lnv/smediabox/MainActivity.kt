package ru.lnv.smediabox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.lnv.smediabox.databinding.ActivityMainBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    lateinit var mVavController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mVavController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }


}