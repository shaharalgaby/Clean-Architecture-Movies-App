package com.share.moviesdemo.data

import com.share.moviesdemo.data.remote.MoviesApi
import com.share.moviesdemo.data.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ListRepository constructor(
    private val moviesApi: MoviesApi,
    private val movieDao: MovieDao
) : Repository {

    fun loadTopRatedList(
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) = flow {
        val movieList = movieDao.getTopRated()
        if(movieList.isNotEmpty()) {
            emit(movieList)
            onSuccess()
        }

        val response = moviesApi.getTopRated()
        if(response?.isSuccessful == true) {
            val movies = response.body()?.repositories
            if(movies != null) {
                movieDao.insertAll(movies)
                emit(movies)
                onSuccess()
            } else {
                onFailure()
            }
        } else {
            onFailure()
        }
    }.flowOn(Dispatchers.IO)

}