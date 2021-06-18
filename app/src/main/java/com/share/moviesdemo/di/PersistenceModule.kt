package com.share.moviesdemo.di

import androidx.room.Room
import com.share.moviesdemo.R
import com.share.moviesdemo.data.room.AppDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidApplication

val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().getString(R.string.database_name)
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().MovieDao() }
}