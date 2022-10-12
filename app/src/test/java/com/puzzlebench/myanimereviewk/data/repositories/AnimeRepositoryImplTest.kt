package com.puzzlebench.myanimereviewk.data.repositories

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRemoteRepository
import com.puzzlebench.myanimereviewk.domain.repositories.AnimeRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AnimeRepositoryImplTest {

    @Mock
    private lateinit var animeRemoteRepository: AnimeRemoteRepository

    @Mock
    private lateinit var coroutineDispatcher: CoroutineDispatcher

    private lateinit var animeRepositoryImpl: AnimeRepositoryImpl

    @Before
    fun setUp() {
        animeRepositoryImpl = AnimeRepositoryImpl(
            animeRemoteRepository,
            coroutineDispatcher
        )
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(animeRemoteRepository, coroutineDispatcher)
    }

    @Test
    fun testGetAnimeTopList(): Unit = runBlocking {
        animeRemoteRepository.getAnimeTopList()

        verify(animeRemoteRepository).getAnimeTopList()
    }

    @Test
    fun testGetAnimeDetail(): Unit = runBlocking {
        animeRemoteRepository.getAnimeDetail(1)

        verify(animeRemoteRepository).getAnimeDetail(1)
    }

    @Test
    fun testGetAnimeSearchList(): Unit = runBlocking {
        animeRemoteRepository.getAnimeSearchList("data")

        verify(animeRemoteRepository).getAnimeSearchList("data")
    }
}