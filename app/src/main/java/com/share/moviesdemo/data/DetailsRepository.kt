package com.share.moviesdemo.data

import com.share.moviesdemo.data.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailsRepository(
    private val movieDao: MovieDao
) : Repository {

    fun getMovieById(id: Long) = flow {
        val movie = movieDao.getMovie(id)
        emit(movie)
    }.flowOn(Dispatchers.IO)

}