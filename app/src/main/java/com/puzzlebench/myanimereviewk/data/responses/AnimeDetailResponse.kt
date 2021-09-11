package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeDetailResponse(
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
    @Json(name = "status")
    val status: String,
    @Json(name = "score")
    val score: Double,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "trailer_url")
    val trailerUrl: String? = String()
)
