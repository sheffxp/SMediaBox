package ru.lnv.smediabox

import android.animation.Animator
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.lnv.smediabox.databinding.ActivitySplashBinding
import ru.lnv.smediabox.extensions.*


class Splash : AppCompatActivity() {
    private var _binding: ActivitySplashBinding? = null
    private val mBinding get() = _binding!!

    lateinit var sharedPrefsSplash: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        sharedPrefsSplash = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        setAnimation()
    }

    private fun setAnimation() {
        mBinding.lottie.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                lifecycleScope.launch {
                    whenStarted {
                        if (sharedPrefsSplash.getBoolean(LOGIN_STATUS, false)) {
                            delay(300)
                            Toast.makeText(mBinding.root.context, "login true", Toast.LENGTH_SHORT).show()
                            startMainActivity(true)
                        } else {
                            Toast.makeText(mBinding.root.context, "login no !!!!!!!!!! ", Toast.LENGTH_SHORT).show()
                            overridePendingTransition(0, 0)
                            startMainActivity()
                        }
                    }
                }
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationStart(animation: Animator?) {}
        })
    }

//    private fun startMainActivity() {
//        Toast.makeText(this, "OK dashboard ", Toast.LENGTH_SHORT).show()
//        val intent = Intent(this, MainActivity::class.java)
//        startActivityWithAnim(intent)
//        finish()
//    }

    private fun startMainActivity(anim:Boolean = false) {


        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        if (anim) {
            (this as? AppCompatActivity)?.overridePendingTransition(
                R.anim.slide_in_up,
                R.anim.slide_out_up
            )
        }
        finish()
    }
}