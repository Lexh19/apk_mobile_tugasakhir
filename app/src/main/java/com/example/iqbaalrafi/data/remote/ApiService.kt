package com.example.iqbaalrafi.data.remote

import com.example.iqbaalrafi.data.remote.response.GenreResponse
import com.example.iqbaalrafi.data.remote.response.MovieResponse
import com.example.iqbaalrafi.utils.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//    @GET("movies/now_playing")
//    suspend fun getMovies(
//        @Query("api_key")apiKey: String = API_KEY
//    ) : Response<MovieResponse>
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key: String = API_KEY,
//        @Query("page") page: Int?
    ): Response<MovieResponse>
    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") key: String?
    ): GenreResponse
}