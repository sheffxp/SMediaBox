package ru.lnv.smediabox.extensions

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import ru.lnv.smediabox.R


const val LOGIN_STATUS = "login_status"
const val SP_NAME = "smediabox"



fun Context.startActivityWithAnim(
    intent: Intent,
    animIn: Int = R.anim.slide_in_up,
    animOut: Int = R.anim.slide_out_up
) {
    startActivity(intent)
    (this as? AppCompatActivity)?.overridePendingTransition(animIn, animOut)
}

private val sharedPrefs: SharedPreferences =
    APP_ACTIVITY.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE )

fun getLoggedStatus(): Boolean = sharedPrefs.getBoolean(LOGIN_STATUS, false)

fun clearAll() {
    sharedPrefs.edit().clear().apply()
}