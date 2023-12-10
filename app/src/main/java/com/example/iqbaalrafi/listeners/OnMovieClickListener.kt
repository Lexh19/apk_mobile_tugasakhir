package com.example.iqbaalrafi.listeners

import com.example.iqbaalrafi.data.remote.response.Movies


interface OnMovieClickListener {
    fun onMovieClick(movies: Movies, genres: String)
}