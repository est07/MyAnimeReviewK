package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeSearchListResponse(
    @Json(name = "data")
    val results: List<AnimeSearchResponse>
)
