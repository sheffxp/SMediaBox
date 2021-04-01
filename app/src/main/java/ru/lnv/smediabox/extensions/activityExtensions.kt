package ru.lnv.smediabox.extensions

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.lnv.smediabox.MainActivity
import ru.lnv.smediabox.R


const val LOGIN_STATUS = "login_status"
const val SP_NAME = "smediabox"

fun replaceFragment(fragment: Fragment, addStack: Boolean = true, bundle: Bundle? = null) {

    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.dataContainer, fragment::class.java, bundle)
            .commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, fragment::class.java, bundle)
            .commit()
    }
}



private val sharedPrefs: SharedPreferences =
    APP_ACTIVITY.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)


fun getLoggedStatus(): Boolean = sharedPrefs.getBoolean(LOGIN_STATUS, false)

fun clearAll() {
    sharedPrefs.edit().clear().apply()
}