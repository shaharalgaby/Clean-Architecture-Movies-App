package com.share.moviesdemo.ui.movie_details

import androidx.lifecycle.*
import com.share.moviesdemo.data.Movie
import kotlinx.coroutines.Dispatchers

class MovieDetailsViewModel(
    private val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase,
    private val movieId: Long
) : ViewModel() {

    val movieDetailsLiveData: LiveData<Movie> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(getMovieDetailsByIdUseCase(movieId).asLiveData())
    }

}