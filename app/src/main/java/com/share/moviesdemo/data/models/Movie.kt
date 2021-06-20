package com.share.moviesdemo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = false) val id: Int,
    var title: String?,
    var popularity: Double?,
    var overview: String?,
    var runtime: String?,
    var genres: ArrayList<Genre?>?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Int?,
    @SerializedName("backdrop_path") val backdrop: String?,
    @SerializedName("poster_path") val poster: String?,
)