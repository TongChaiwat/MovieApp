package com.charmist.movieapp

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(view: View, private val itemClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(view) {
    private val tvTitle = itemView.tvTitle
    private val tvDate = itemView.tvDate
    private val tvDescription = itemView.tvDescription
    private val ivPoster = itemView.ivPoster
    private val context: Context by lazy { itemView.context }

    init {
        itemView.setOnClickListener {
            itemClick(adapterPosition)
        }
    }

    fun bindUi(movie: Movie) {
        tvTitle.text = movie.title
        tvDate.text = movie.release_date
        tvDescription.text = movie.overview
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w92/" + movie.poster_path)
            .into(ivPoster)
    }
}