package com.puzzlebench.myanimereviewk.presentation.di

import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoriesModule = module {
    factory<AnimeRepository> {
        AnimeRepositoryImpl(
            animeRemoteRepository = get(),
            coroutineDispatcher = Dispatchers.IO
        )
    }
}