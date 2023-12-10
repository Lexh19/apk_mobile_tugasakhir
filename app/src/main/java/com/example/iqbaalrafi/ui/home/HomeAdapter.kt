package com.example.iqbaalrafi.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iqbaalrafi.R
import com.example.iqbaalrafi.data.remote.response.Genres
import com.example.iqbaalrafi.data.remote.response.Movies

class HomeAdapter(private val list: List<Movies>): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private val genresList = ArrayList<Genres>()
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val image: ImageView = view.findViewById(R.id.poster)
        val genre: TextView = view.findViewById(R.id.genre)
        val releaseDate: TextView = view.findViewById(R.id.releaseDate)
        val lang: TextView = view.findViewById(R.id.lang)
        val ratingText: TextView = view.findViewById(R.id.ratingText)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = list[position].originalTitle
        holder.lang.text = list[position].originalLanguage
        holder.releaseDate.text = list[position].releaseDate
        holder.ratingText.text = list[position].voteAverage.toString()
        holder.ratingBar.rating = list[position].voteAverage?.div(2) ?: 0f
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500/${list[position].posterPath}")
            .into(holder.image)

        val map = genresList.associate { it.id to it.name }
        val genres = StringBuilder()

        val genresId = ArrayList<Int>()
        if (list[position].genreIds != null) {
            list[position].genreIds?.let { genresId.addAll(it) }
        }

        for (genreId in genresId) {
            if (map.containsKey(genreId)) {
                genres.append(map[genreId])
                genres.append(", ")
            }
        }

// Menghapus koma ekstra di akhir
        if (genres.isNotEmpty()) {
            genres.deleteCharAt(genres.length - 2)
        }

        holder.genre.text = genres.toString()
    }
    override fun getItemCount(): Int {
        return list.size
    }


}
