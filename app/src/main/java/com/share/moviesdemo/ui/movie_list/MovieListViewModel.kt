package com.share.moviesdemo.ui.movie_list

import androidx.lifecycle.*
import com.share.moviesdemo.data.Movie
import kotlinx.coroutines.Dispatchers

class MovieListViewModel(
    getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    val movieListLiveData: LiveData<List<Movie>> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(getTopRatedMoviesUseCase(
            onSuccess = {
                        //TODO handle success
            },
            onFailure = {
                //TODO handle failure
            }
        ).asLiveData())
    }

}