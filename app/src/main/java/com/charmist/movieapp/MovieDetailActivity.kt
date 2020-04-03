package com.charmist.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie:Movie? = intent.getParcelableExtra("movie")

        tvTitle.text = movie?.title
        tvDate.text = movie?.release_date
        tvDescription.text = movie?.overview
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w92/" + movie?.poster_path)
            .into(ivPoster)

    }
}
