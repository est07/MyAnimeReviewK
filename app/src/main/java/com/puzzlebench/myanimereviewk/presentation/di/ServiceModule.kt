package com.example.myitemssearchk.presentation.di

import com.puzzlebench.myanimereviewk.data.apis.JikanApi
import com.puzzlebench.myanimereviewk.presentation.di.ManagerNetwork
import com.puzzlebench.myanimereviewk.presentation.di.ManagerNetwork.Companion.RETROFIT_API
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single(named(RETROFIT_API)) { ManagerNetwork().createWebService() }
    single { get<Retrofit>(named(RETROFIT_API)).create(JikanApi::class.java) }
}
