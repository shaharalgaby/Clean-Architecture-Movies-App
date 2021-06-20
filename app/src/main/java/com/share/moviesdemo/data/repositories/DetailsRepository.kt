package com.share.moviesdemo.data.repositories

import android.util.Log
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
        try {
            val cachedMovie = movieDao.getMovie(id)
            emit(cachedMovie)

            val response = moviesApi.getMovieDetails(cachedMovie.id)
            if (response?.isSuccessful == true) {
                response.body()?.apply {
                    movieDao.updateMovie(this)
                    emit(this)
                }
            }
        } catch (e: Exception) {
            Log.d("DetailsRepository", e.message ?: "")
        }
    }.flowOn(Dispatchers.IO)
}