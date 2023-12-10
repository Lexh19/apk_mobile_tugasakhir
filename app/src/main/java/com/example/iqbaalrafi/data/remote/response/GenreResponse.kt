package com.example.iqbaalrafi.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenreResponse(

	@field:SerializedName("genres")
	val genres: List<Genres>? = null
)