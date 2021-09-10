package com.puzzlebench.myanimereviewk.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import com.puzzlebench.myanimereviewk.presentation.states.AnimeListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AnimeListViewModel(
    private val animeRepository: AnimeRepository,
    private val _animeListState: MutableLiveData<AnimeListState>
) : ViewModel() {

    val getAnimeListStateLiveData: LiveData<AnimeListState>
        get() = _animeListState

    fun getAnimeTopList() {

        viewModelScope.launch {
            animeRepository.getAnimeTopList()
                .onStart { _animeListState.value = AnimeListState.Loading }
                .catch {
                    _animeListState.value = AnimeListState.Error
                }
                .collect { _animeListState.value = AnimeListState.Success(it) }
        }
    }
}
