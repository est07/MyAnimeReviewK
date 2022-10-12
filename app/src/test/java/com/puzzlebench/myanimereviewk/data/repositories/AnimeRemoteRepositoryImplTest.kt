package com.puzzlebench.myanimereviewk.data.repositories

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.puzzlebench.myanimereviewk.data.apis.JikanApi
import com.puzzlebench.myanimereviewk.data.responses.*
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AnimeRemoteRepositoryImplTest {

    @Mock
    private lateinit var api: JikanApi

    private lateinit var animeRemoteRepositoryImpl: AnimeRemoteRepositoryImpl

    @Before
    fun setUp() {
        animeRemoteRepositoryImpl = AnimeRemoteRepositoryImpl(api)
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(api)
    }

    @Test
    fun testGetAnimeTopList(): Unit = runBlocking {

        val animeTopListResponse: AnimeTopListResponse = mock()
        `when`(api.getAnimeTopList()).thenReturn(animeTopListResponse)

        animeRemoteRepositoryImpl.getAnimeTopList().collect {
            assert(it == animeTopListResponse.results)
        }

        verify(api).getAnimeTopList()
    }

    @Test
    fun testGetAnimeDetail(): Unit = runBlocking {

        val animeDetailResponse = AnimeDetailResponse(
            results = AnimeDetailDataResponse(
                title = "title",
                images = AnimeDetailImageJPGResponse(
                    imageJPG = AnimeDetailImageResponse(
                        imageUrl = "imageUrl"
                    )
                ),
                synopsis = "synopsis",
                type = "type",
                episodes = 1,
                status = "status",
                score = 5.0,
                rating = "rating",
                rank = 1,
                trailer = AnimeDetailTrailerResponse(
                    trailerUrl = "trailerUrl"
                )
            )
        )

        val animeDetail = AnimeDetail(
            title = "title",
            imageUrl = "imageUrl",
            synopsis = "synopsis",
            type = "type",
            episodes = 1,
            status = "status",
            score = 5.0,
            rating = "rating",
            rank = 1,
            trailerUrl = "trailerUrl"
        )
        `when`(api.getAnimeDetail(1L)).thenReturn(animeDetailResponse)

        animeRemoteRepositoryImpl.getAnimeDetail(1L).collect {
           assert(it == animeDetail)
        }

        verify(api).getAnimeDetail(1L)
    }

    @Test
    fun testGetAnimeSearchList(): Unit = runBlocking {
        val animeSearchListResponse: AnimeSearchListResponse = mock()
        `when`(api.getAnimeSearchList("anime")).thenReturn(animeSearchListResponse)

        animeRemoteRepositoryImpl.getAnimeSearchList("anime").collect {
            assert(it == animeSearchListResponse.results)
        }

        verify(api).getAnimeSearchList("anime")
    }
}
