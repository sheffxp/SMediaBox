package ru.lnv.smediabox.extensions
import android.content.SharedPreferences
import android.view.View
import ru.lnv.smediabox.MainActivity
import ru.lnv.smediabox.data.database.DatabaseRepository


lateinit var APP_ACTIVITY: MainActivity
lateinit var FRAGMENT: View
lateinit var REPOSITORY:DatabaseRepository
const val TYPE_DATABASE = "type_database"
const val LOGIN_STATUS = "login_status"
const val SP_NAME = "smediabox"


const val TYPE_FIREBASE = "type_firebase"

lateinit var EMAIL:String
lateinit var PASSWORD:String
lateinit var SHAREDPREF: SharedPreferences


