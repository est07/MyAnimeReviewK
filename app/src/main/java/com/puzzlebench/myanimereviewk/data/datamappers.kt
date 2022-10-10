package com.puzzlebench.myanimereviewk.data

import com.puzzlebench.myanimereviewk.data.responses.AnimeDetailResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeSearchResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeTopResponse
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop

fun AnimeTopResponse.toDomainAnimeTop(): AnimeTop =
    AnimeTop(
        id = id,
        rank = rank,
        title = title,
        imageUrl = images.imageJPG.imageUrl,
        type = type,
        episodes = episodes,
        score = score,
        startDate = aired.startDate,
        endDate = aired.endDate
    )

fun AnimeDetailResponse.toDomainAnimeDetail(): AnimeDetail =
    AnimeDetail(
        title = title,
        imageUrl = imageUrl,
        synopsis = synopsis,
        type = type,
        episodes = episodes,
        status = status,
        score = score,
        rating = rating,
        rank = rank,
        trailerUrl = trailerUrl?: String()
    )

fun AnimeSearchResponse.toDomainAnimeSearch(): AnimeSearch =
    AnimeSearch(
        title = title,
        imageUrl = imageUrl
    )
