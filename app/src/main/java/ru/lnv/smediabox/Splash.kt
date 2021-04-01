package ru.lnv.smediabox

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.lnv.smediabox.databinding.ActivitySplashBinding
import ru.lnv.smediabox.extensions.APP_ACTIVITY

import ru.lnv.smediabox.extensions.getLoggedStatus
import ru.lnv.smediabox.extensions.startActivityWithAnim


class Splash : AppCompatActivity() {
    private var _binding: ActivitySplashBinding? = null
    private val mBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        setAnimation()
    }

    private fun setAnimation() {
        mBinding.lottie.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                lifecycleScope.launch {
                    whenStarted {
                        if (getLoggedStatus()) {
                            delay(300)
                            Toast.makeText(APP_ACTIVITY, "Yes", Toast.LENGTH_SHORT).show()
                            startMainActivity()
                        } else {
                            delay(300)
                            Toast.makeText(APP_ACTIVITY, "No", Toast.LENGTH_SHORT).show()
                            startMainActivity()
//                            overridePendingTransition(0, 0)
//                            startActivity(ScreenLinks.authorization.loadIntentOrReturnNull())
                            // finish()
                        }
                    }
                }
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationStart(animation: Animator?) {}
        })
    }

    private fun startMainActivity() {
        finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivityWithAnim(intent)
    }
}