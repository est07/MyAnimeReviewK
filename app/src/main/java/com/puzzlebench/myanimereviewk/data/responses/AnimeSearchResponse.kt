package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeSearchResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "image_url")
    val imageUrl: String
)
