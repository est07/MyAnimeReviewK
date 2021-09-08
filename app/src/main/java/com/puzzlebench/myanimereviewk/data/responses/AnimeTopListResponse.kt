package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeTopListResponse(
    @Json(name = "top")
    val results: List<AnimeTopResponse>
)
