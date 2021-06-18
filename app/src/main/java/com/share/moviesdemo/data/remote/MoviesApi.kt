package com.share.moviesdemo.data.remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

const val REQUEST_POSTFIX = "api_key=e7148d4c360cb247d76021be8ba9310b&language=en-US&page=1"
interface MoviesApi {

    @GET("movie/top_rated?$REQUEST_POSTFIX")
    suspend fun getTopRated(): Response<RepositoryResponse>?
}