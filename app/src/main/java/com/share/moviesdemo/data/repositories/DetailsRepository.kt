package com.share.moviesdemo.data.repositories

import android.util.Log
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.data.models.RequestState
import com.share.moviesdemo.data.remote.MoviesApi
import com.share.moviesdemo.data.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailsRepository(
    private val moviesApi: MoviesApi,
    private val movieDao: MovieDao
) : Repository {

    fun getMovieById(id: Long) = flow {
        val requestState = RequestState<Movie>()
        emit(requestState)
        try {
            val cachedMovie = movieDao.getMovie(id)
            emit(requestState.success(cachedMovie))

            val response = moviesApi.getMovieDetails(cachedMovie.id)
            if (response?.isSuccessful == true) {
                response.body()?.apply {
                    movieDao.updateMovie(this)
                    emit(requestState.success(this))
                }
            } else {
                emit(requestState.error("Network error"))
            }
        } catch (e: Exception) {
            emit(requestState.error("Network error"))
        }
    }.flowOn(Dispatchers.IO)
}