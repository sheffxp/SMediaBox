package ru.lnv.smediabox

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.lnv.smediabox.databinding.ActivityMainBinding
import ru.lnv.smediabox.extensions.*
import kotlin.math.absoluteValue


class MainActivity : AppCompatActivity() {

    lateinit var mVavController: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!

    private var startX = 0f
    private var startY = 0f
    private var isSliding = false
    private val threshold = 10
    private lateinit var screenSize: Point



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        SHAREDPREF = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        APP_ACTIVITY = this
        mVavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        //для удаления настроек авторизации
        // SHAREDPREF.edit().clear().apply()


        mBinding.navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_movies -> {
                    mVavController.navigate(R.id.movieFragment)
                }
                R.id.navigation_tvs -> {
                    mVavController.navigate(R.id.TVsFragment)
                }
                R.id.navigation_discover -> {
                    mVavController.navigate(R.id.searchFragment)
                }
                R.id.navigation_profile -> {
                    mVavController.navigate(R.id.profileFragment)
                }
            }
            true
        }

        if (SHAREDPREF.getBoolean(LOGIN_STATUS, false)) {
            mBinding.navView.isVisible = true
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
            mVavController.navigate(R.id.action_loginFragment_to_movieFragment)
        } else {
            mBinding.navView.isVisible = false
            mVavController.navigate(R.id.loginFragment)
        }


        FRAGMENT = mBinding.root
        screenSize = Point().apply { windowManager.defaultDisplay.getSize(this) }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        var handled = false

        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                // запоминаем точку старта
                startX = ev.x
                startY = ev.y
                println("------------------------------------------------" + ev.x + "----------------"+ ev.y)
            }

            MotionEvent.ACTION_MOVE -> {

//                // нужно определить, является ли текущий жест "смахиванием вниз"

                println("------------------------      isSlidingDown        ------------------------" + isSlidingDown(startX, startY, ev).toString())

               if ((isSlidingDown(startX, startY, ev) && canSlideDown()) || isSliding) {

                    if (!isSliding) {
//                        // момент, когда мы определили, что пользователь "смахивает" экран
//                        // начиная с этого жеста все последующие ACTION_MOVE мы будем
//                        // воспринимать как "смахивание"
                        isSliding = true
                        onSlidingStarted()
//
//                        // сообщим всем остальным обработчикам, что жест закончился
//                        // и им не нужно больше ничего обрабатывать
                        ev.action = MotionEvent.ACTION_CANCEL
                        super.dispatchTouchEvent(ev)
                    }
//
//                    // переместим контейнер на соответсвующую Y координату
//                    // но не выше, чем точка старта
                   FRAGMENT.y = (ev.y - startY).coerceAtLeast(0f)
//
//                    handled = true
                }
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
//                if (isSliding) {
//                    // если пользователь пытался "смахнуть" экран...
//                    isSliding = false
//                    onSlidingFinished()
//                    handled = true
//                    if (shouldClose(ev.y - startY)) {
//                        // закрыть экран
//                        println("=====================         closeDownAndDismiss            =========================================")
//                        closeDownAndDismiss()
//                    } else {
//                        // вернуть все как было
//                        FRAGMENT.y = 0f
//                    }
//                }
                startX = 0f
                startY = 0f
            }
        }
        return if (handled) true else super.dispatchTouchEvent(ev)
    }

    private fun onSlidingFinished() {

    }

    private fun onSlidingStarted() {
            println("onSlidingStarted ----------------------------------------------   ")
    }

    private fun shouldClose(delta: Float): Boolean {
        return delta > screenSize.y / 6
    }

    private fun closeDownAndDismiss() {
        val start = FRAGMENT.y
        val finish = screenSize.y.toFloat()
        val positionAnimator = ObjectAnimator.ofFloat(FRAGMENT, "y", start, finish)
        positionAnimator.duration = 100
        positionAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                finish()
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationStart(animation: Animator) {}
        })
        positionAnimator.start()
    }

    private fun isSlidingDown(startX: Float, startY: Float, ev: MotionEvent): Boolean {
        val deltaX = (startX - ev.x).absoluteValue
        if (deltaX > threshold) return false
        val deltaY = ev.y - startY
        return deltaY > threshold
    }

    fun canSlideDown(): Boolean{
        return false
    }
}