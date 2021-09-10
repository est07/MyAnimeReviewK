package com.puzzlebench.myanimereviewk.presentation.states

import com.puzzlebench.myanimereviewk.domain.models.AnimeTop

sealed class AnimeListState {
    data class Success(val item: List<AnimeTop>) : AnimeListState()
    object Loading : AnimeListState()
    object Error : AnimeListState()
}
