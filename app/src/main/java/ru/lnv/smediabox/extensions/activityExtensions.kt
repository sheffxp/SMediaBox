package ru.lnv.smediabox.extensions

import android.app.usage.StorageStatsManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageStats
import android.os.Build
import android.os.Process
import android.os.storage.StorageManager
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

fun calculateCache():Long {
    val cacheSize: Long

    if (Build.VERSION.SDK_INT >= 26) {
        val ssm = APP_ACTIVITY.getSystemService(Context.STORAGE_STATS_SERVICE) as StorageStatsManager
        val user = Process.myUserHandle()

        val sm = ssm.queryStatsForPackage(StorageManager.UUID_DEFAULT, APP_ACTIVITY.packageName, user)

        cacheSize = sm.cacheBytes
    } else {
        val p = PackageStats(APP_ACTIVITY.packageName)

        cacheSize = p.cacheSize
    }
    return cacheSize
}