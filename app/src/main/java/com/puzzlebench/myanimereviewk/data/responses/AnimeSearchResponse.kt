package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeSearchResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "synopsis")
    val synopsis: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "episodes")
    val episodes: Int,
    @Json(name = "score")
    val score: Double,
    @Json(name = "rated")
    val rated: String
)
