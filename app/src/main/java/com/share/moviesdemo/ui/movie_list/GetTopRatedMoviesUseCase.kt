package com.share.moviesdemo.ui.movie_list

import com.share.moviesdemo.data.repositories.ListRepository
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.data.models.RequestState
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase(
    private val listRepository: ListRepository
) {
    operator fun invoke(): Flow<RequestState<List<Movie>>> {
        return listRepository.loadTopRatedList()
    }
}