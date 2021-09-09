package com.puzzlebench.myanimereviewk.presentation

import android.app.Application
import com.example.myitemssearchk.presentation.di.repositoriesModule
import com.example.myitemssearchk.presentation.di.serviceModule
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
                    repositoriesModule
                )
            )
        }
    }
}
