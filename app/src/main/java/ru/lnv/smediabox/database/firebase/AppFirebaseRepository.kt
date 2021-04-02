package ru.lnv.smediabox.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import ru.lnv.smediabox.database.DatabaseRepository
import ru.lnv.smediabox.extensions.EMAIL
import ru.lnv.smediabox.extensions.PASSWORD
import ru.lnv.smediabox.models.AppDevice

class AppFirebaseRepository: DatabaseRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override val allDevice : LiveData<List<AppDevice>> = AllDeviceLiveData()

    override suspend fun insert(device: AppDevice, onSuccess: () -> Unit) {

    }

    override suspend fun delete(device: AppDevice, onSuccess: () -> Unit) {

    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString())}
            }
    }

    override fun signOut() {
        mAuth.signOut()
    }
}