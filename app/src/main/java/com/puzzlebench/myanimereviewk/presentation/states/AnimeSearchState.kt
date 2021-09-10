package com.puzzlebench.myanimereviewk.presentation.states

import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch

sealed class AnimeSearchState{
    data class Success(val item: List<AnimeSearch>) : AnimeSearchState()
    object Loading : AnimeSearchState()
    object Error : AnimeSearchState()
}
