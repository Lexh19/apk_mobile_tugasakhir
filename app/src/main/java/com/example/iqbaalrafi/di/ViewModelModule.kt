package com.example.iqbaalrafi.di

import com.example.iqbaalrafi.ui.home.HomeViewModel
import com.example.iqbaalrafi.ui.login.LoginViewModel
import com.example.iqbaalrafi.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { HomeViewModel(get())}
}