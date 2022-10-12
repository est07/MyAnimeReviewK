package com.puzzlebench.myanimereviewk.domain.repositories

import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {

    suspend fun getAnimeTopList(): Flow<List<AnimeTop>>

    suspend fun getAnimeDetail(id:Long): Flow<AnimeDetail>

    suspend fun getAnimeSearchList(search: String): Flow<List<AnimeSearch>>
}
