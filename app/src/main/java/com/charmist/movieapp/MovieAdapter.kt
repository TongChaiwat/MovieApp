package com.charmist.movieapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

class MovieAdapter(private val itemClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieViewHolder>() {

    var values: List<Movie> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(
            viewHolder
        ) {
            itemClick(values[it])
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindUi(values[position])
    }

}