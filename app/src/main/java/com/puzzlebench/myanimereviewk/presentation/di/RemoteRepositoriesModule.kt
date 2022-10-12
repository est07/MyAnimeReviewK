package com.example.myitemssearchk.presentation.di

import com.puzzlebench.myanimereviewk.data.repositories.AnimeRemoteRepositoryImpl
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRemoteRepository
import org.koin.dsl.module

val remoteRepositoriesModule = module {
    factory<AnimeRemoteRepository> { AnimeRemoteRepositoryImpl(api = get()) }
}
