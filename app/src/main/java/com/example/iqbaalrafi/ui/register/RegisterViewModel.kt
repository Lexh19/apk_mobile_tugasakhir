package com.example.iqbaalrafi.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iqbaalrafi.AppRepository
import com.example.iqbaalrafi.data.local.AppDatabase
import com.example.iqbaalrafi.data.local.UserEntity
import kotlinx.coroutines.launch

class RegisterViewModel(private val appRepository: AppRepository): ViewModel() {
    // variabel untuk merubah data
    private val isRegister = MutableLiveData<Boolean>()
    fun observeIsRegister(): LiveData<Boolean> = isRegister

    fun insertUser(user: UserEntity){
        viewModelScope.launch {
            try {
                appRepository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable){
                e.printStackTrace()
            }
        }
    }
}