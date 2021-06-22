package com.share.moviesdemo.ui.movie_details

import androidx.lifecycle.*
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.data.models.RequestState
import kotlinx.coroutines.Dispatchers

class MovieDetailsViewModel(
    private val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase,
    private val movieId: Long
) : ViewModel() {
    val movieDetailsLiveData: LiveData<RequestState<Movie>> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(getMovieDetailsByIdUseCase(movieId).asLiveData())
    }

}