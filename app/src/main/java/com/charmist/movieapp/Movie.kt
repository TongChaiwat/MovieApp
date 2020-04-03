package com.charmist.movieapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int?,
    val overview: String?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?
) : Parcelable