package ru.lnv.smediabox.screen.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import ru.lnv.smediabox.database.firebase.AppFirebaseRepository
import ru.lnv.smediabox.extensions.APP_ACTIVITY
import ru.lnv.smediabox.extensions.REPOSITORY
import ru.lnv.smediabox.extensions.TYPE_FIREBASE

class LoginFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String, onSuccess:()->Unit){
        when(type){
            TYPE_FIREBASE -> {
                REPOSITORY = AppFirebaseRepository()
                REPOSITORY.connectToDatabase({ onSuccess() }, {
                    Toast.makeText(
                        APP_ACTIVITY,
                        it,
                        Toast.LENGTH_SHORT
                    ).show()
                })
            }
        }
    }


}