package com.puzzlebench.myanimereviewk.data.repositories

import com.puzzlebench.myanimereviewk.data.apis.JikanApi
import com.puzzlebench.myanimereviewk.data.toDomainAnimeDetail
import com.puzzlebench.myanimereviewk.data.toDomainAnimeSearch
import com.puzzlebench.myanimereviewk.data.toDomainAnimeTop
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeRepositoryImpl(private val api: JikanApi) : AnimeRepository {

    override suspend fun getAnimeTopList(): Flow<List<AnimeTop>> =
        flow {
            emit(api.getAnimeTopList().results.map { it.toDomainAnimeTop() })
        }

    override suspend fun getAnimeDetail(id: Long): Flow<AnimeDetail> =
        flow {
            emit(api.getAnimeDetail(id).results.toDomainAnimeDetail())
        }

    override suspend fun getAnimeSearchList(search: String): Flow<List<AnimeSearch>> =
        flow {
            emit(api.getAnimeSearchList(search).results.map { it.toDomainAnimeSearch() })
        }
}
