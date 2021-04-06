package ru.lnv.smediabox.data.database

import androidx.lifecycle.LiveData
import ru.lnv.smediabox.models.AppDevice

interface DatabaseRepository {
    val allDevice: LiveData<List<AppDevice>>
    suspend fun insert(device: AppDevice, onSuccess: () -> Unit)
    suspend fun delete(device: AppDevice, onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit){}

    fun signOut(){}
}