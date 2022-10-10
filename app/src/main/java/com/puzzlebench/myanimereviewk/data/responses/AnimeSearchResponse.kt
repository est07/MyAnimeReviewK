package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeSearchResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "images")
    val images: AnimeSearchImageJPGResponse
)

data class AnimeSearchImageJPGResponse(
    @Json(name = "jpg")
    val imageJPG: AnimeSearchImageResponse,
)

data class AnimeSearchImageResponse(
    @Json(name = "image_url")
    val imageUrl: String,
)