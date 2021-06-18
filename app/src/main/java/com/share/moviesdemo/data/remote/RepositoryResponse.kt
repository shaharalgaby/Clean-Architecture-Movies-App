package com.share.moviesdemo.data.remote

import com.google.gson.annotations.SerializedName
import com.share.moviesdemo.data.Movie

data class RepositoryResponse (
    @SerializedName("page") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("results") val repositories: ArrayList<Movie>
)