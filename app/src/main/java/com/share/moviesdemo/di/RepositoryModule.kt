package com.share.moviesdemo.di

import com.share.moviesdemo.data.DetailsRepository
import com.share.moviesdemo.data.ListRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DetailsRepository(get()) }
    single { ListRepository(get(), get()) }
}