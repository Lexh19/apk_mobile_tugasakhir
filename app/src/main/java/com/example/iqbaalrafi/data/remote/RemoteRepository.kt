package com.example.iqbaalrafi.data.remote

import com.example.iqbaalrafi.utils.Constant.API_KEY


class RemoteRepository(private val apiService: ApiService) {
    suspend fun getPopularMovies() = apiService.getPopularMovies()

}