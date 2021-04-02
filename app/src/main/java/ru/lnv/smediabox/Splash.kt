package ru.lnv.smediabox

import android.animation.Animator
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.lnv.smediabox.databinding.ActivitySplashBinding
import ru.lnv.smediabox.extensions.LOGIN_STATUS
import ru.lnv.smediabox.extensions.SP_NAME



class Splash : AppCompatActivity() {
    private var _binding: ActivitySplashBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var Prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        Prefs = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        setAnimation()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setAnimation() {
        mBinding.lottie.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                lifecycleScope.launch {
                    whenStarted {
                        if (LoggedStatus()) {
                            delay(300)
                            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
                        } else {
                            overridePendingTransition(0, 0)
                        }
                        startMainActivity()
                    }
                }
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationStart(animation: Animator?) {}
        })
    }

    private fun LoggedStatus(): Boolean = Prefs.getBoolean(LOGIN_STATUS, false)

    private fun startMainActivity() {
        finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}