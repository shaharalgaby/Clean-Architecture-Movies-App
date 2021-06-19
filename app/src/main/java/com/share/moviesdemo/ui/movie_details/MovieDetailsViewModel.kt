package com.share.moviesdemo.ui.movie_details

//import android.arch.lifecycle.ViewModel
import androidx.lifecycle.*
import com.share.moviesdemo.data.DetailsRepository
import com.share.moviesdemo.data.Movie
import kotlinx.coroutines.Dispatchers

class MovieDetailsViewModel(
    private val detailsRepository: DetailsRepository,
    private val movieId: Long
) : ViewModel() {

    val movieDetailsLiveData: LiveData<Movie> = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emitSource(detailsRepository.getMovieById(movieId).asLiveData())
    }

}