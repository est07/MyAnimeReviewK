package com.puzzlebench.myanimereviewk.data

import com.puzzlebench.myanimereviewk.data.responses.*
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import org.junit.Assert.assertEquals
import org.junit.Test

class MappersTests {

    private val  animeTopResponse = AnimeTopResponse(
        id = 1L,
        rank = 1,
        title = "title",
        images = AnimeTopImageJPGResponse(
            imageJPG = AnimeTopImageResponse(
                imageUrl = "imageUrl"
            )
        ),
        type = "type",
        episodes = 1,
        score = 5.0,
        aired = AnimeTopAired(
            startDate = "startDate",
            endDate = "endDate"
        )
    )

    private val  animeDetailResponse = AnimeDetailResponse(
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

    private val animeSearchListResponse =
        AnimeSearchResponse(
            title = "title",
            imageUrl = "imageUrl"
        )

    @Test
    fun toDomainAnimeTop() {
        val result = animeTopResponse.toDomainAnimeTop()

        assertEquals(
            AnimeTop(
                id = 1L,
                rank = 1,
                title = "title",
                imageUrl = "imageUrl",
                type = "type",
                episodes = 1,
                score = 5.0,
                startDate = "startDate",
                endDate = "endDate"
            ), result
        )
    }

    @Test
    fun toDomainAnimeDetail() {
        val result = animeDetailResponse.toDomainAnimeDetail()

        assertEquals(
            AnimeDetail(
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
            ), result
        )
    }

    @Test
    fun toDomainAnimeSearch() {
        val result = animeSearchListResponse.toDomainAnimeSearch()

        with(animeSearchListResponse) {
            assertEquals(title, result.title)
            assertEquals(imageUrl, result.imageUrl)
        }
    }

}