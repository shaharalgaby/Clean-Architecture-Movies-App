package com.share.moviesdemo.ui.movie_list

import androidx.lifecycle.*
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.data.models.RequestState
import kotlinx.coroutines.Dispatchers

class MovieListViewModel(
    getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    val movieListLiveData: LiveData<RequestState<List<Movie>>> =
        liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(getTopRatedMoviesUseCase().asLiveData())
        }
}