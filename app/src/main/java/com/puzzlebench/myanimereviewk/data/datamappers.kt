package com.puzzlebench.myanimereviewk.data

import com.puzzlebench.myanimereviewk.data.responses.AnimeSearchResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeTopResponse
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop

fun AnimeTopResponse.toDomainAnimeTop(): AnimeTop =
    AnimeTop(
        rank = rank,
        title = title,
        imageUrl = imageUrl,
        type = type,
        episodes = episodes,
        score = score,
        startDate = startDate,
        endDate = endDate
    )

fun AnimeSearchResponse.toDomainAnimeSearch(): AnimeSearch =
    AnimeSearch(
        title = title,
        imageUrl = imageUrl,
        synopsis = synopsis,
        type = type,
        episodes = episodes,
        score = score,
        rated = rated
    )
