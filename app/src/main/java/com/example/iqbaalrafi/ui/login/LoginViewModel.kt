package com.example.iqbaalrafi.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iqbaalrafi.AppRepository
import com.example.iqbaalrafi.data.local.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel(private val appRepository: AppRepository): ViewModel() {
    // variabel untuk merubah data
    private val isLogin = MutableLiveData<UserEntity>()
    fun observeIsLogin(): LiveData<UserEntity> = isLogin

    fun getDataLogin(email: String, password: String){
        viewModelScope.launch {
            when(val result = appRepository.getUser(email, password)){
                is UserEntity -> {
                    isLogin.postValue(result)
                }
            }
        }
    }
}