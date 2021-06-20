package com.share.moviesdemo.di

import com.share.moviesdemo.data.repositories.DetailsRepository
import com.share.moviesdemo.data.repositories.ListRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DetailsRepository(get(), get()) }
    single { ListRepository(get(), get()) }
}