package com.puzzlebench.myanimereviewk.data

import com.puzzlebench.myanimereviewk.data.responses.AnimeDetailDataResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeSearchResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeTopResponse
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop

fun AnimeTopResponse.toDomainAnimeTop(): AnimeTop =
    AnimeTop(
        id = id,
        rank = rank ?: 0,
        title = title ?: String(),
        imageUrl = images?.imageJPG?.imageUrl ?: String(),
        type = type ?: String(),
        episodes = episodes ?: 0,
        score = score ?: 0.0,
        startDate = aired?.startDate ?: String(),
        endDate = aired?.endDate ?: String()
    )

fun AnimeDetailDataResponse.toDomainAnimeDetail(): AnimeDetail =
    AnimeDetail(
        title = title ?: String(),
        imageUrl = images?.imageJPG?.imageUrl ?: String(),
        synopsis = synopsis ?: String(),
        type = type ?: String(),
        episodes = episodes ?: 0,
        status = status ?: String(),
        score = score ?: 0.0,
        rating = rating ?: String(),
        rank = rank ?: 0,
        trailerUrl = trailer?.trailerUrl ?: String()
    )

fun AnimeSearchResponse.toDomainAnimeSearch(): AnimeSearch =
    AnimeSearch(
        title = title ?: String(),
        imageUrl = images?.imageJPG?.imageUrl ?: String()
    )
