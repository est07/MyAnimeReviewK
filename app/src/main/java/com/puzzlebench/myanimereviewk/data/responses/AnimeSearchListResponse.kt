package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeSearchListResponse(
    @Json(name = "results")
    val results: List<AnimeSearchResponse>
)
