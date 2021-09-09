package com.example.myitemssearchk.presentation.di

import com.puzzlebench.myanimereviewk.data.repositories.AnimeRepositoryImpl
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import org.koin.dsl.module

val repositoriesModule = module {
    factory<AnimeRepository> { AnimeRepositoryImpl(api = get()) }
}