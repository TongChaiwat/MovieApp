package com.charmist.movieapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Apis {

    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

    private val interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(
                chain.request().newBuilder()
                    .addHeader("api-key", "2f70b177e4ba26509a63e4bd9e23bbdcb6634d60")
                    .build()
            )
        }
    }

    val api: MovieApi

    init {
        api = Retrofit.Builder()
            .baseUrl("https://scb-movies-api.herokuapp.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MovieApi::class.java)
    }

}