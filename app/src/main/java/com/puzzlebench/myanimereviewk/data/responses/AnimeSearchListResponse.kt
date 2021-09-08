package com.puzzlebench.myanimereviewk.data.responses

import com.puzzlebench.myanimereviewk.data.responses.AnimeTopResponse
import com.squareup.moshi.Json

data class AnimeSearchListResponse(
    @Json(name = "results")
    val results: List<AnimeTopResponse>
)
