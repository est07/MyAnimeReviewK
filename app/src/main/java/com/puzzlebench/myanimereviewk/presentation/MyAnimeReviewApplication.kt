package com.puzzlebench.myanimereviewk.presentation

import android.app.Application
import com.example.myitemssearchk.presentation.di.remoteRepositoriesModule
import com.example.myitemssearchk.presentation.di.serviceModule
import com.example.myitemssearchk.presentation.di.viewModelModule
import com.puzzlebench.myanimereviewk.presentation.di.repositoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MyAnimeReviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyAnimeReviewApplication)
            loadKoinModules(
                listOf(
                    serviceModule,
                    remoteRepositoriesModule,
                    repositoriesModule,
                    viewModelModule
                )
            )
        }
    }
}
