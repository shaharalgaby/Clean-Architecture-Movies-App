package com.share.moviesdemo.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.share.moviesdemo.MainCoroutinesRule
import com.share.moviesdemo.Utils
import com.share.moviesdemo.data.ListRepository
import com.share.moviesdemo.data.remote.MoviesApi
import com.share.moviesdemo.data.room.MovieDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class ListRepositoryTest {

    private lateinit var repository: ListRepository
    private val service: MoviesApi = mock()
    private val movieDao: MovieDao = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        repository = ListRepository(service, movieDao)
    }

    @Test
    fun loadMoviesTest() = runBlocking {
        val mockData = Utils.mockMovieList()
        whenever(movieDao.getTopRated()).thenReturn(emptyList())
//        whenever(service.getTopRated()).thenReturn(
//            Response.success(mockData)
//        )

        repository.loadTopRatedList(
            onSuccess = {},
            onFailure = {}
        )

        verify(movieDao, atLeastOnce()).getTopRated()
        verify(service, atLeastOnce()).getTopRated()
        verify(movieDao, atLeastOnce()).insertAll(mockData)
    }
}