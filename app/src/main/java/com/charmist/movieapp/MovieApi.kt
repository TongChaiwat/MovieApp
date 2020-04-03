package com.charmist.movieapp

import retrofit2.Call
import retrofit2.http.*

interface MovieApi {

    @GET("/api/movies/search?query=man")
    fun getMovie(): Call<MovieResponse>

}