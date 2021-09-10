package com.puzzlebench.myanimereviewk.presentation.states

import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail

sealed class AnimeDetailState {
    data class Success(val item: AnimeDetail) : AnimeDetailState()
    object Loading : AnimeDetailState()
    object Error : AnimeDetailState()
}