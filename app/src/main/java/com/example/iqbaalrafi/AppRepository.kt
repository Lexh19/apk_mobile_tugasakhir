package com.example.iqbaalrafi

import com.example.iqbaalrafi.data.local.LocalRepository
import com.example.iqbaalrafi.data.local.UserEntity
import com.example.iqbaalrafi.data.remote.RemoteRepository
import com.example.iqbaalrafi.utils.Constant.API_KEY

class AppRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) {
    suspend fun insertUser(user:UserEntity){
        localRepository.insertUser(user)
    }
    suspend fun getUser(email: String, password: String): UserEntity{
        return localRepository.getUser(email, password)
    }
    suspend fun getPopularMovies() = remoteRepository.getPopularMovies()

}