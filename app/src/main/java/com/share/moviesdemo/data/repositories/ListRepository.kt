package com.share.moviesdemo.data.repositories

import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.data.models.RequestState
import com.share.moviesdemo.data.remote.MoviesApi
import com.share.moviesdemo.data.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ListRepository constructor(
    private val moviesApi: MoviesApi,
    private val movieDao: MovieDao
) : Repository {

    fun loadTopRatedList() = flow {
        val requestState = RequestState<List<Movie>>()
        emit(requestState)
        try {
            val movieList = movieDao.getTopRated()
            if (movieList.isNotEmpty()) emit(requestState.success(movieList))

            val response = moviesApi.getTopRated(1)
            if (response?.isSuccessful == true) {
                val movies = response.body()?.repositories
                if (movies != null) {
                    movieDao.insertAll(movies)
                    emit(requestState.success(movies))
                } else {
                    emit(requestState.error("Error updating list"))
                }
            } else {
                emit(requestState.error("Error updating list"))
            }
        } catch (e: Exception) {
            emit(requestState.error("Error updating list"))
        }
    }.flowOn(Dispatchers.IO)

}