package com.share.moviesdemo.viewmodel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.share.moviesdemo.MainCoroutinesRule
import com.share.moviesdemo.Utils
import com.share.moviesdemo.data.ListRepository
import com.share.moviesdemo.data.Movie
import com.share.moviesdemo.data.remote.MoviesApi
import com.share.moviesdemo.data.room.MovieDao
import com.share.moviesdemo.ui.movie_list.MovieListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListViewModelTest {
    private lateinit var viewModel: MovieListViewModel
    private lateinit var mainRepository: ListRepository
    private val moviesApi: MoviesApi = mock()
    private val movieDao: MovieDao = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        mainRepository = ListRepository(moviesApi, movieDao)
        viewModel = MovieListViewModel(mainRepository)
    }

    @Test
    fun fetchMovieListTest() = runBlocking {
        val mockData = Utils.mockMovieList()
        whenever(movieDao.getTopRated()).thenReturn(mockData)

        val fetchedData = mainRepository.loadTopRatedList(
            onSuccess = {},
            onFailure = {}
        ).asLiveData()

        val observer: Observer<List<Movie>> = mock()
        fetchedData.observeForever(observer)

        delay(500L)

        verify(movieDao, atLeastOnce()).getTopRated()
        verify(observer).onChanged(mockData)
        fetchedData.removeObserver(observer)
    }
}