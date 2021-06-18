package com.share.moviesdemo.ui.movie_list

import androidx.lifecycle.*
import com.share.moviesdemo.data.ListRepository
import com.share.moviesdemo.data.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    listRepository: ListRepository
) : ViewModel() {

    val movieListLiveData: LiveData<List<Movie>> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(listRepository.loadTopRatedList(
            onSuccess = {},
            onFailure = {}
        ).asLiveData())
    }

}