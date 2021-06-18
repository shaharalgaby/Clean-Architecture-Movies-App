package com.share.moviesdemo

import android.app.Application
import com.share.moviesdemo.di.networkModule
import com.share.moviesdemo.di.persistenceModule
import com.share.moviesdemo.di.repositoryModule
import com.share.moviesdemo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}