package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json


data class AnimeDetailResponse(
    @Json(name = "data")
    val results: AnimeDetailDataResponse
)

data class AnimeDetailDataResponse(
    @Json(name = "title")
    val title: String? = String(),
    @Json(name = "images")
    val images:  AnimeDetailImageJPGResponse?,
    @Json(name = "synopsis")
    val synopsis: String? = String(),
    @Json(name = "type")
    val type: String? = String(),
    @Json(name = "episodes")
    val episodes: Int? = 0,
    @Json(name = "status")
    val status: String? = String(),
    @Json(name = "score")
    val score: Double? = 0.0,
    @Json(name = "rating")
    val rating: String? = String(),
    @Json(name = "rank")
    val rank: Int? = 0,
    @Json(name = "trailer")
    val trailer: AnimeDetailTrailerResponse?
)

data class AnimeDetailImageJPGResponse(
    @Json(name = "jpg")
    val imageJPG: AnimeDetailImageResponse?,
)

data class AnimeDetailImageResponse(
    @Json(name = "image_url")
    val imageUrl: String? = String(),
)

data class AnimeDetailTrailerResponse(
    @Json(name = "url")
    val trailerUrl: String? = String(),
)
