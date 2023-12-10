package com.example.iqbaalrafi.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.iqbaalrafi.AppRepository
import com.example.iqbaalrafi.data.remote.response.MovieResponse
import kotlinx.coroutines.launch
import retrofit2.Response


class HomeViewModel(private val appRepository: AppRepository): ViewModel() {
   private val getMovie = MutableLiveData<Response<MovieResponse>>()
   val observeMovie: LiveData<Response<MovieResponse>> = getMovie

   fun getMovie(){
      viewModelScope.launch {
         try {
             val result = appRepository.getPopularMovies()
            getMovie.postValue(result)
         } catch (e: Exception){
            e.printStackTrace()
         }
      }
   }
}