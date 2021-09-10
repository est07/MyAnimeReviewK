package com.puzzlebench.myanimereviewk.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import com.puzzlebench.myanimereviewk.presentation.states.AnimeDetailState
import com.puzzlebench.myanimereviewk.presentation.states.AnimeSearchState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AnimeDetailViewModel(
        private val animeRepository: AnimeRepository,
        private val _animeDetailState: MutableLiveData<AnimeDetailState>,
        private val _animeSearchState: MutableLiveData<AnimeSearchState>
) : ViewModel() {

    val getAnimeDetailStateLiveData: LiveData<AnimeDetailState>
        get() = _animeDetailState

    val getAnimeSearchStateStateLiveData: LiveData<AnimeSearchState>
        get() = _animeSearchState

    fun getAnimeTopList(id:Long) {
        viewModelScope.launch {
            animeRepository.getAnimeDetail(id)
                    .onStart { _animeDetailState.value = AnimeDetailState.Loading }
                    .catch {
                        _animeDetailState.value = AnimeDetailState.Error
                    }
                    .collect { _animeDetailState.value = AnimeDetailState.Success(it) }
        }
    }

    fun getAnimeSearchList(search: String) {
        viewModelScope.launch {
            animeRepository.getAnimeSearchList(search)
                    .onStart { _animeSearchState.value = AnimeSearchState.Loading }
                    .catch {
                        _animeSearchState.value = AnimeSearchState.Error
                    }
                    .collect { _animeSearchState.value = AnimeSearchState.Success(it) }
        }
    }
}