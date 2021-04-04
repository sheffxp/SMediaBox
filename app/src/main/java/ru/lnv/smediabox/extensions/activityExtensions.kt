package ru.lnv.smediabox.extensions

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import ru.lnv.smediabox.MainActivity
import ru.lnv.smediabox.Splash

private val sharedPrefs: SharedPreferences =
    APP_ACTIVITY.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)


fun getLoggedStatus(): Boolean = sharedPrefs.getBoolean(LOGIN_STATUS, false)


fun clearAll() {
    sharedPrefs.edit().clear().apply()
}

fun restartActivity() {
    val intent = Intent(APP_ACTIVITY, Splash::class.java)
    APP_ACTIVITY.startActivity(intent)
    APP_ACTIVITY.finish()
}