package com.share.moviesdemo.di

import com.share.moviesdemo.ui.movie_details.MovieDetailsViewModel
import com.share.moviesdemo.ui.movie_list.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MovieListViewModel(get()) }

    viewModel { parameters -> MovieDetailsViewModel(get(), movieId = parameters.get()) }
}