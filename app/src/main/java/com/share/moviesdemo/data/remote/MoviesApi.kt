package com.share.moviesdemo.data.remote

import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.data.models.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val REQUEST_POSTFIX = "api_key=e7148d4c360cb247d76021be8ba9310b&language=en-US"
interface MoviesApi {

    @GET("movie/top_rated?$REQUEST_POSTFIX")
    suspend fun getTopRated(@Query("page") page: Int): Response<MovieListResponse>?

    @GET("movie/{movie_id}?$REQUEST_POSTFIX")
    suspend fun getMovieDetails(@Path(value = "movie_id", encoded = true) movieId: Int): Response<Movie>?
}