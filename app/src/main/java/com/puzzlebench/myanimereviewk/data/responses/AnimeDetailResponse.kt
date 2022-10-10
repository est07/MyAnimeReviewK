package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json


data class AnimeDetailResponse(
    @Json(name = "data")
    val results: AnimeDetailDataResponse
)

data class AnimeDetailDataResponse(
    @Json(name = "title")
    val title: String,
    @Json(name = "images")
    val images:  AnimeDetailImageJPGResponse,
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
    @Json(name = "trailer")
    val trailer: AnimeDetailTrailerResponse
)

data class AnimeDetailImageJPGResponse(
    @Json(name = "jpg")
    val imageJPG: AnimeDetailImageResponse,
)

data class AnimeDetailImageResponse(
    @Json(name = "image_url")
    val imageUrl: String,
)

data class AnimeDetailTrailerResponse(
    @Json(name = "url")
    val trailerUrl: String? = String(),
)
