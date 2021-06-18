package com.share.moviesdemo.data.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movie/top_rated")
    fun getTopRated(): Response<RepositoryResponse>?
}