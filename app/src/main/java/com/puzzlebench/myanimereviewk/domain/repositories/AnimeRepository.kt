package com.puzzlebench.myanimereviewk.domain.repositories

import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    fun getAnimeTopList(): Flow<List<AnimeTop>>

    fun getAnimeSearchList(search: String): Flow<List<AnimeSearch>>
}
