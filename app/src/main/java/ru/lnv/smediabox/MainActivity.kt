package ru.lnv.smediabox

import android.R.attr.name
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.lnv.smediabox.databinding.ActivityMainBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.LOGIN_STATUS
import ru.lnv.smediabox.extensions.SHAREDPREF
import ru.lnv.smediabox.extensions.SP_NAME


class MainActivity : AppCompatActivity() {

    lateinit var mVavController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        SHAREDPREF = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        APP_ACTIVITY = this
        mVavController = Navigation.findNavController(this, R.id.nav_host_fragment)
            //для удаления настроек авторизации
           // SHAREDPREF.edit().clear().apply()

        if (SHAREDPREF.getBoolean(LOGIN_STATUS, false)){
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
            mVavController.navigate(R.id.action_loginFragment_to_movieFragment)
            Toast.makeText(APP_ACTIVITY, "true", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(APP_ACTIVITY, "false", Toast.LENGTH_SHORT).show()
        }

    }


}