package com.share.moviesdemo.data.models

import com.google.gson.annotations.SerializedName
import com.share.moviesdemo.data.models.Movie

data class MovieListResponse (
    @SerializedName("page") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("results") val repositories: ArrayList<Movie>
)