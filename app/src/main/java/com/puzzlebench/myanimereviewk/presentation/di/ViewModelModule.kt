package com.example.myitemssearchk.presentation.di

import androidx.lifecycle.MutableLiveData
import com.puzzlebench.myanimereviewk.presentation.viewModels.AnimeDetailViewModel
import com.puzzlebench.myanimereviewk.presentation.viewModels.AnimeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        AnimeListViewModel(animeRepository = get(), _animeListState = MutableLiveData())
    }
    viewModel {
        AnimeDetailViewModel(
            animeRepository = get(),
            _animeDetailState = MutableLiveData(),
            _animeSearchState = MutableLiveData()
        )
    }
}
