package com.puzzlebench.myanimereviewk.domain.repositories

import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class AnimeRepositoryImpl(
    private val animeRemoteRepository: AnimeRemoteRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : AnimeRepository {
    override suspend fun getAnimeTopList(): Flow<List<AnimeTop>> {
        return withContext(coroutineDispatcher) {
            animeRemoteRepository.getAnimeTopList()
        }
    }

    override suspend fun getAnimeDetail(id: Long): Flow<AnimeDetail> {
        return withContext(coroutineDispatcher) {
            animeRemoteRepository.getAnimeDetail(id)
        }
    }

    override suspend fun getAnimeSearchList(search: String): Flow<List<AnimeSearch>> {
        return withContext(coroutineDispatcher) {
            animeRemoteRepository.getAnimeSearchList(search)
        }
    }
}
