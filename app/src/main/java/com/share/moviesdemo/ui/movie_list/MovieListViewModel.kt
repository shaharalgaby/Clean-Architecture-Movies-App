package com.share.moviesdemo.ui.movie_list

import androidx.lifecycle.*
import com.share.moviesdemo.data.Movie
import kotlinx.coroutines.Dispatchers

class MovieListViewModel(
    getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    private val _isLoading = MutableLiveData(true)
    val isLoading: MutableLiveData<Boolean> = _isLoading

    val toastMessage: MutableLiveData<String?> = MutableLiveData<String?>()

    val movieListLiveData: LiveData<List<Movie>> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(getTopRatedMoviesUseCase(
            onLoading = {
               _isLoading.postValue(true)
            },
            onSuccess = {
                _isLoading.postValue(false)
            },
            onFailure = {
                _isLoading.postValue(false)
                toastMessage.postValue("Can't refresh data")
            }
        ).asLiveData())
    }

}