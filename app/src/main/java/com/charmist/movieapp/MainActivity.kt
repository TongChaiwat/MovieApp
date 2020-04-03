package com.charmist.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MovieAdapter {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie", it)
            startActivity(intent)
        }
        rvMovie.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = adapter
        }

        requestMovieList()
    }

    fun requestMovieList() {
        progressLoading.visibility = View.VISIBLE
        Apis.api.getMovie().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                progressLoading.visibility = View.GONE
                Toast.makeText(this@MainActivity, t.message.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                progressLoading.visibility = View.GONE
                val movieList = response.body()?.results
                (rvMovie.adapter as MovieAdapter).values = movieList ?: emptyList()
            }
        })


    }

    fun mockMovie() {
        val movieList = mutableListOf(
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER2"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER3"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER4"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER5"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER6"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER7"
            ),
            Movie(
                1,
                "Avenger overview",
                "https://lumiere-a.akamaihd.net/v1/images/avengers2-movieposter-web_210f6394.jpeg?region=0%2C0%2C600%2C900",
                "3/4/60",
                "AVENGER8"
            )
        )
    }

}
