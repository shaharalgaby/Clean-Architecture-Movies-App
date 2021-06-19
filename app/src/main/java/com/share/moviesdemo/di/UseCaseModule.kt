package com.share.moviesdemo.di

import com.share.moviesdemo.ui.movie_details.GetMovieDetailsByIdUseCase
import com.share.moviesdemo.ui.movie_list.GetTopRatedMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetTopRatedMoviesUseCase(get()) }
    single { GetMovieDetailsByIdUseCase(get()) }
}