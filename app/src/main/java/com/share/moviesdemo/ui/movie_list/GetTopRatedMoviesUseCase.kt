package com.share.moviesdemo.ui.movie_list

import com.share.moviesdemo.data.repositories.ListRepository
import com.share.moviesdemo.data.models.Movie
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase(
    private val listRepository: ListRepository
) {
    operator fun invoke(
        onLoading: () -> Unit,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ): Flow<List<Movie>> {
        return listRepository.loadTopRatedList(onLoading, onSuccess, onFailure)
    }
}