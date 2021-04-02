package ru.lnv.smediabox.extensions

import android.content.Context
import android.content.SharedPreferences

private val sharedPrefs: SharedPreferences =
    APP_ACTIVITY.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)


fun getLoggedStatus(): Boolean = sharedPrefs.getBoolean(LOGIN_STATUS, false)


fun clearAll() {
    sharedPrefs.edit().clear().apply()
}