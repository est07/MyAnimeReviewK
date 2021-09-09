package com.puzzlebench.myanimereviewk.data.repositories

import com.puzzlebench.myanimereviewk.data.apis.JikanApi
import com.puzzlebench.myanimereviewk.data.toDomainAnimeSearch
import com.puzzlebench.myanimereviewk.data.toDomainAnimeTop
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeRepositoryImpl(private val api: JikanApi) : AnimeRepository {

    override fun getAnimeTopList(): Flow<List<AnimeTop>> =
            flow {
                api.getAnimeTopList().results.map { it.toDomainAnimeTop() }

            }

    override fun getAnimeSearchList(search: String): Flow<List<AnimeSearch>> =
            flow {
                api.getAnimeSearchList(search).results.map { it.toDomainAnimeSearch() }
            }
}
