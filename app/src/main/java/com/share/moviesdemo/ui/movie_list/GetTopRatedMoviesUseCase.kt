package com.share.moviesdemo.ui.movie_list

import com.share.moviesdemo.data.ListRepository
import com.share.moviesdemo.data.Movie
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase(
    private val listRepository: ListRepository) {
    operator fun invoke(
        onLoading: () -> Unit,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ): Flow<List<Movie>> {
        return listRepository.loadTopRatedList(onLoading, onSuccess, onFailure)
    }
}