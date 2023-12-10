package com.example.iqbaalrafi.di

import com.example.iqbaalrafi.AppRepository
import com.example.iqbaalrafi.data.local.LocalRepository
import com.example.iqbaalrafi.data.remote.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module{
    single { LocalRepository(get()) }
    single { RemoteRepository(get()) }
    single { AppRepository(get(),get()) }
}